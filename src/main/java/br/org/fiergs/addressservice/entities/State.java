package br.org.fiergs.addressservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
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

    @Size(max = 20, message = "Chave deve ser menor que 21 caracteres")
    private String key;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 30, message = "Nome deve ter no maxímo 50 caracteres")
    private String name;

    @NotEmpty(message = "Região geográfica é obrigatória")
    private String geographicRegion;

    @Max(value = 99, message = "Código de mercado deve ser menor que 100 caracteres")
    private Integer ibgeCode;

    @NotEmpty(message = "Sigla é obrigatória")
    @Size(max = 2, message = "Sigla ser menor que 3 caracteres")
    private String initials;

    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;
}
