package com.example.demo.model.entities.enums;

public enum TipoPedido
{
    JANELA(0, "Janela"),
    PORTA(1, "Porta"),
    PORTAO(2, "Portão"),
    TOLDO(3, "Toldo");

    private int cod;
    private String descricao;

    private TipoPedido(int cod, String descricao)
    {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod()
    {
        return cod;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public static TipoPedido toEnum(Integer cod) throws IllegalAccessException
    {
        if(cod == null)
        {
            return null;
        }

        for(TipoPedido x : TipoPedido.values())
        {
            if(cod.equals(x.getCod()))
            {
                return x;
            }
        }

        throw new IllegalAccessException("Id Inválido : " + cod);
    }

}