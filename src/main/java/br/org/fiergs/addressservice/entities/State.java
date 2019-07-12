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

    @Size(max = 30, message = "Chave deve ter até 30 caracteres")
    private String key;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 150, message = "Nome deve ter até 150 caracteres")
    private String name;

    @Size(max = 15, message = "Região geográfica deve ter até 15 caracteres")
    private String geographicRegion;

    @Size(max = 20, message = "Código IBGE deve ter até 20 caracteres")
    private String ibgeCode;

    @NotEmpty(message = "Sigla é obrigatória")
    @Size(max = 2, message = "Sigla deve ter até 2 caracteres")
    private String initials;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;
}
