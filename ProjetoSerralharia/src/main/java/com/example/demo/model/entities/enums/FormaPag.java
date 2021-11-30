package com.example.demo.model.entities.enums;

public enum FormaPag {


    CREDITO(0, "credito"),
    DEBITO(1, "debito"),
    ESPECIE(2, "especie");

    private int cod;
    private String descricao;

    FormaPag(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static FormaPag toEnum(Integer cod) throws IllegalAccessException
    {
        if(cod == null)
        {
            return null;
        }

        for(FormaPag y : FormaPag.values())
        {
            if(cod.equals(y.getCod()))
            {
                return y;
            }
        }

        throw new IllegalAccessException("Id Inválido : " + cod);
    }

}
