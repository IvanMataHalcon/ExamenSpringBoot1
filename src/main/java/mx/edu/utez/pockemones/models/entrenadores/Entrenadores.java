package mx.edu.utez.pockemones.models.entrenadores;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pockemones.models.pokemon.Pokemon;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "entrenadores")
@NoArgsConstructor
@Setter
@Getter
public class Entrenadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String team;

    @OneToMany
    @JsonIgnore
    private List<Pokemon> pokemonList;

    public Entrenadores(Long id, String name, String team, List<Pokemon> pokemonList) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.pokemonList = pokemonList;
    }
}
