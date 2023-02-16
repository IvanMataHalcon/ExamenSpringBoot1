package mx.edu.utez.pockemones.models.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pockemones.models.entrenadores.Entrenadores;

import javax.persistence.*;


@Entity
@Table(name ="pokemon")
@NoArgsConstructor
@Setter
@Getter
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private Integer high;
    @Column(nullable = false)
    private Integer health;
    @Column(nullable = false)
    private Integer atack;
    @Column(nullable = false)
    private Integer defender;

    @ManyToOne
    @JoinColumn(name = "id_entrenador", nullable = false)
    private Entrenadores entrenadores;

    public Pokemon(Long id, String name, String type, Integer high, Integer health, Integer atack, Integer defender, Entrenadores entrenadores) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.high = high;
        this.health = health;
        this.atack = atack;
        this.defender = defender;
        this.entrenadores = entrenadores;
    }
}
