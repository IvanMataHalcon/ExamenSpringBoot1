package mx.edu.utez.pockemones.services.pokemon;

import mx.edu.utez.pockemones.models.pokemon.Pokemon;
import mx.edu.utez.pockemones.models.pokemon.PokemonRepository;

import mx.edu.utez.pockemones.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PokemonService {
    @Autowired
    private PokemonRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Pokemon>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<Pokemon> getOne(Long id){
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "El pokemon no se encontro"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> insert(Pokemon pokemon){
        return new Response<>(
                this.repository.saveAndFlush(pokemon),
                false,
                200,
                "Registrada correctamente"
        );
    }
}
