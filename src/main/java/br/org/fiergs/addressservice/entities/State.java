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
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 50, message = "Nome deve ter no maxímo 50 caracteres")
    private String name;

    @Column(name = "geographic_region")
    private String geographicRegion;

    @Column(name = "ibge_code")
    private String ibgeCode;

    private String initials;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;
}
