package br.org.fiergs.addressservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_STATE")
@SequenceGenerator(name = "seqCad_state", sequenceName = "SEQCAD_STATE", allocationSize = 1)
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_state")
    private Long id;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 50, message = "Nome deve ter no maxímo 50 caracteres")
    private String name;

    @Column(name = "geographicregion")
    private String geographicRegion;

    @Column(name = "ibgecode")
    private String ibgeCode;

    private String initials;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;
}
