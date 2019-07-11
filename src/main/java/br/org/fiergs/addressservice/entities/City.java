package br.org.fiergs.addressservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
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

    @Size(max = 20, message = "Chave deve ser menor que 21 caracteres")
    private String key;

    @NotNull(message = "Código é obrigatório")
    @Max(value = 99999, message = "Código deve ser menor que 100000 caracteres")
    private Integer code;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 30, message = "Nome deve ter no maxímo 50 caracteres")
    private String name;

    @Max(value = 9999, message = "Código CAT deve ser menor que 10000 caracteres")
    private Integer catCode;

    @Max(value = 999, message = "Código grupo pessoa deve ser menor que 1000 caracteres")
    private Integer groupPersonCode;

    @Max(value = 999, message = "Código área deve ser menor que 1000 caracteres")
    private Integer areaCode;

    @Max(value = 99999999, message = "Cep inicial deve ser menor que 100000000 caracteres")
    private Integer initialCep;

    @Max(value = 99999999, message = "Cep final deve ser menor que 100000000 caracteres")
    private Integer finalCep;

    @Max(value = 99999999, message = "Número de habitantes deve ser menor que 100000000 caracteres")
    private Integer numberInhabitants;

    //se brasil tem que ser obrigatório.
    @Max(value = 9999999, message = "Código IBGE deve ser menor que 10000000 caracteres")
    private Integer codeIbge;

    @Max(value = 999999, message = "Código REC deve ser menor que 1000000 caracteres")
    private Integer codeRec;

    @Max(value = 9999999, message = "Código MEC deve ser menor que 10000000 caracteres")
    private Integer codeMec;

    private Integer codeDetran;

    private String structuredCodeSesi;

    private String structuredCodeSenai;

    @Enumerated(EnumType.STRING)
    private Location location;

    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "id_state")
    private State state;
}
