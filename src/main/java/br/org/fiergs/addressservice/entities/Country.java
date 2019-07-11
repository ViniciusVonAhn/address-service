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
@Table(name = "CAD_COUNTRY")
@SequenceGenerator(name = "seqCad_country", sequenceName = "SEQCAD_COUNTRY", allocationSize = 1)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_country")
    private Long id;

    @Size(max = 20, message = "Chave deve ser menor que 21 caracteres")
    private String key;

    @Size(max = 3, message = "Sigla deve ser menor que 4 caracteres")
    private String initials;

    //@Length(max = 999, message = "Código de mercado deve ser menor que 1000 caracteres")
    @Max(value = 999, message = "Código de mercado deve ser menor que 1000 caracteres")
    private Integer marketCode;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 30, message = "Nome deve ser menor que 31 caracteres")
    private String name;

    @NotEmpty(message = "Nome internacional é obrigatório")
    @Size(max = 30, message = "Nome internacional deve ser menor que 31 caracteres")
    private String internationalName;

    @Size(max = 15, message = "Nome reduzido deve ser menor que 16 caracteres")
    private String reducedName;

    @Size(max = 3, message = "Código ISO deve ser menor que 4 caracteres")
    private String isoCode;

    @Size(max = 10, message = "Código SISBACEN deve ser menor que 11 caracteres")
    private String sisbacenCode;

    @Size(max = 10, message = "Código IBGE deve ser menor que 11 caracteres")
    private String ibgeCode;

    @Size(max = 2, message = "Sigla 2P ser menor que 3 caracteres")
    private String initialTwoP;

    private boolean active = true;
}
