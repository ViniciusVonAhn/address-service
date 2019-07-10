package br.org.fiergs.addressservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_CITY")
@SequenceGenerator(name = "seqCad_city", sequenceName = "SEQCAD_CITY", allocationSize = 1)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_city")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_state")
    private State state;

    @NotNull(message = "Nome é obrigatório")
    @Size(max = 50, message = "Nome deve ter no maxímo 50 caracteres")
    private String name;

    /*@ManyToOne
    @JoinColumn(name = "id_cep")
    private Cep cep;*/

    @Column(name = "ibgecode")
    private String codeIbge;

    @Column(name = "reccode")
    private String codeRec;

    @Column(name = "meccode")
    private String codeMec;
}
