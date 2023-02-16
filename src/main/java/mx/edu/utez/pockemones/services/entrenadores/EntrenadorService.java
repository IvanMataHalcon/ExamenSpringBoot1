package mx.edu.utez.pockemones.services.entrenadores;

import mx.edu.utez.pockemones.models.entrenadores.Entrenadores;
import mx.edu.utez.pockemones.models.entrenadores.EntrenadoresRepository;
import mx.edu.utez.pockemones.models.pokemon.Pokemon;
import mx.edu.utez.pockemones.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class EntrenadorService {
    @Autowired
    private EntrenadoresRepository repository;


    @Transactional(readOnly = true)
    public Response<List<Entrenadores>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<Entrenadores> getOne(Long id){
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
                "El Entrenador no se encontro"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenadores> insert(Entrenadores entrenadores){
        return new Response<>(
                this.repository.saveAndFlush(entrenadores),
                false,
                200,
                "Registrada correctamente"
        );
    }

}
