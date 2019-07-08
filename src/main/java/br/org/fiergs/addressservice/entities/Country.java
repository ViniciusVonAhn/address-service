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
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long code;

    @NotEmpty(message = "Nome é obrigatório")
    private String name;

    @Column(name = "reduced_name")
    private String reducedName;

    @Column(name = "international_name")
    private String internationalName;

    private String initials;
}
