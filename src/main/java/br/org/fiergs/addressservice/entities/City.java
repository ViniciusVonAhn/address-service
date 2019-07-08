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
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_state")
    private State state;

    @NotNull(message = "Nome é obrigatório")
    @Size(max = 50, message = "Nome deve ter no maxímo 50 caracteres")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_cep")
    private Cep cep;

    @Column(name = "ibge_code")
    private String codeIbge;

    @Column(name = "rec_code")
    private String codeRec;

    @Column(name = "mec_code")
    private String codeMec;
}
