package mx.edu.utez.pockemones.controllers.entrenadores.entreadoresDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pockemones.models.entrenadores.Entrenadores;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EntrenadorDto {
    private Long id;
    @NotEmpty
    @Size(min=3, max = 50)
    private String name;
    @NotEmpty
    @Size(min=3, max=50)
    private String team;

    public Entrenadores getEnteador(){
        return new Entrenadores(
                getId(),
                getName(),
                getTeam(),
                null
        );
    }
}
