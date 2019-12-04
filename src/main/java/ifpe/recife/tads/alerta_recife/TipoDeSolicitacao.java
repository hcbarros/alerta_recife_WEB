package ifpe.recife.tads.alerta_recife;

public enum TipoDeSolicitacao {

    VISTORIA(1), LONA(2), CAPINACAO(3), ENTULHOS(4);
    
    public int tipo;

    TipoDeSolicitacao(int valor) {
        this.tipo = valor;
    }

}
