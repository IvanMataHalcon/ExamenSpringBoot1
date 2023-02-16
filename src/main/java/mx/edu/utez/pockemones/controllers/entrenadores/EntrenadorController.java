package mx.edu.utez.pockemones.controllers.entrenadores;

import mx.edu.utez.pockemones.controllers.entrenadores.entreadoresDto.EntrenadorDto;
import mx.edu.utez.pockemones.controllers.pokemon.dtos.PokemonDto;
import mx.edu.utez.pockemones.models.entrenadores.Entrenadores;
import mx.edu.utez.pockemones.models.pokemon.Pokemon;
import mx.edu.utez.pockemones.services.entrenadores.EntrenadorService;
import mx.edu.utez.pockemones.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-entrenador/entrenador/")
@CrossOrigin(origins = {"*"})
public class EntrenadorController {
    @Autowired
    private EntrenadorService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Entrenadores>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Entrenadores>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Entrenadores>> insert(@RequestBody EntrenadorDto entrenadorDto){
        return new ResponseEntity<>(
                this.service.insert(entrenadorDto.getEnteador()),
                HttpStatus.CREATED
        );
    }
}
