import java.util.Objects;
import java.util.Vector;

public class ThreadDeOrdenacao extends Thread{
    private Integer[] vetor;
    private Processadores numeroDeProcessadores;


    public ThreadDeOrdenacao (Integer[] metade, Processadores numeroDeProcessadores) throws Exception {
        if (metade==null)
            throw new Exception ("Vetor metade ausente");

        if (numeroDeProcessadores==null)
            throw new Exception ("Valor do numeroDeProcessadores ausente");

        this.vetor = metade;
        this.numeroDeProcessadores = numeroDeProcessadores;
    }

    public Integer getNumeroDeProcessadores() {
        return this.numeroDeProcessadores;
    }

    public Integer[] getVetor() {
        return vetor;
    }

    public void run() {
        int tamanho = vetor.length;
        int tamanhoMetade = tamanho / 2;

        Integer[] metadeEsquerda = new Integer[tamanhoMetade];
        Integer[] metadeDireita = new Integer[tamanho - tamanhoMetade];

        System.out.println("Vetor da esquerda: ");
        for (int i = 0; i < tamanhoMetade; i++) {
            metadeEsquerda[i] = vetor[i];
            System.out.println("esquerda: " + metadeEsquerda[i]);
        }
        System.out.println("Vetor da esquerda: ");
        for (int i = 0; i < tamanho - tamanhoMetade; i++) {
            metadeDireita[i] = vetor[tamanhoMetade + i];
            System.out.println("direita: " + metadeDireita[i]);
        }

        if (numeroDeProcessadores.isDisponivel()) {
            try {
                ThreadDeOrdenacao thread1 = new ThreadDeOrdenacao(metadeDireita, this.numeroDeProcessadores);
                ThreadDeOrdenacao thread2 = new ThreadDeOrdenacao(metadeEsquerda, this.numeroDeProcessadores);
                thread1.join();
                thread2.join();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {


        }

    }
}

