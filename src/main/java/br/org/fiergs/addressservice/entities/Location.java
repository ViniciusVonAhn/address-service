package br.org.fiergs.addressservice.entities;

public enum Location {

    CAPITAL("Capital"),
    REGIAOMETROPOLITANA("Região Metropolitana");

    private String descricao;

    Location(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
