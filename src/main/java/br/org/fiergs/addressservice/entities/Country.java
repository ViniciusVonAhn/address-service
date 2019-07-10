package br.org.fiergs.addressservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_COUNTRY")
@SequenceGenerator(name = "seqCad_country", sequenceName = "SEQCAD_COUNTRY", allocationSize = 1)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_country")
    private Long id;

    private Long code;

    @NotEmpty(message = "Nome é obrigatório")
    private String name;

    private String reducedName;

    private String internationalName;

    private String initials;
}
