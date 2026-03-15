package com.wsdev.simpleos.model;

public enum OrderStatus
{
    CONCLUIDO( "Concluído" ),
    CANCELADO( "Cancelado" ),
    PENDENTE( "Pendente" ),
    EM_ANDAMENTO( "Em andamento" ),
    PENDENCIAS( "Pendencias" );

    private String description;

    OrderStatus( String description )
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
}
