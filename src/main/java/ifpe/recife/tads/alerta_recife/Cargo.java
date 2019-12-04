package ifpe.recife.tads.alerta_recife;

public enum Cargo {

    GERENTE(1), ANALISTA(2), TECNICO(3);

    public int numCargo;

    Cargo(int valor) {
        this.numCargo = valor;
    }

}
