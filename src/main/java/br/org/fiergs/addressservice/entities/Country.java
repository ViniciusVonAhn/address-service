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
@Table(name = "CCOR_COUNTRY")
@SequenceGenerator(name = "seqCcor_country", sequenceName = "SEQCCOR_COUNTRY", allocationSize = 1)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCcor_country")
    private Long id;

    @Size(max = 30, message = "Chave deve ter até 30 caracteres")
    private String key;

    @NotEmpty(message = "Sigla é obrigatório")
    @Size(max = 3, message = "Sigla deve ter até 3 caracteres")
    private String initials;

    @Size(max = 30, message = "Nome deve ser menor que 30 caracteres")
    private String marketCode;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ser menor que 151 caracteres")
    //@UniqueElements(message = "Já existe um cadastro com este nome")
    private String name;

    @Size(max = 100, message = "Nome internacional deve ter até 100 caracteres")
    private String internationalName;

    @Size(max = 50, message = "Nome reduzido deve ter até 50 caracteres")
    private String reducedName;

    @Size(max = 30, message = "Código ISO deve ter até 30 caracteres")
    private String isoCode;

    @Size(max = 30, message = "Código SISBACEN deve ter até 30 caracteres")
    private String sisbacenCode;

    @NotEmpty(message = "Código IBGE é obrigatório")
    @Size(max = 30, message = "Código IBGE deve ter até 30 caracteres")
    private String ibgeCode;

    @Size(max = 2, message = "Sigla 2P deve ter até 2 caracteres")
    private String initialTwoP;

    private boolean active = true;
}
