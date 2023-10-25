public class Processadores {
    private Integer numeroDeProcessadores;

    public Processadores(Integer numeroDeProcessadores) {
        this.numeroDeProcessadores = numeroDeProcessadores;
    }

    public Integer getNumeroDeProcessadores() {
        return numeroDeProcessadores;
    }

    public boolean isDisponivel() {
        return this.numeroDeProcessadores >= 1;
    }

    public void diminuiProcessador() {
        this.numeroDeProcessadores = this.numeroDeProcessadores - 1;
    }
}
