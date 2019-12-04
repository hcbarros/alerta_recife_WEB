package ifpe.recife.tads.alerta_recife;

public enum TipoDeRisco {

    DESLIZAMENTO(1), ALAGAMENTO(2), ESTRUTURAL(3);

    public int tipo;

    TipoDeRisco(int valor) {
        this.tipo = valor;
    }

}
