package mx.edu.utez.pockemones.controllers.pokemon.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pockemones.models.entrenadores.Entrenadores;
import mx.edu.utez.pockemones.models.pokemon.Pokemon;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDto {
    private Long id;
    @NotEmpty
    @Size(min=1 , max = 50)
    private String name;
    @NotEmpty
    @Size(min=1 , max = 50)
    private String type;
    @NotEmpty
    private Integer high;
    @NotEmpty
    private Integer health;
    @NotEmpty
    private Integer atack;
    @NotEmpty
    private Integer defender;

    private Entrenadores entrenadores;

    public Pokemon getPokemon(){
        return new Pokemon(
                getId(),
                getName(),
                getType(),
                getHigh(),
                getHealth(),
                getAtack(),
                getDefender(),
                getEntrenadores()
        );
    }
}
