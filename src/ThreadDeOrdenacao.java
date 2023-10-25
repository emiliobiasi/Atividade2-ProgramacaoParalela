import java.util.Objects;
import java.util.Vector;

public class ThreadDeOrdenacao extends Thread{
    private Vector<Integer> metade;

    private Integer threadId;

    private Integer posicaoEncontrada;


    public ThreadDeOrdenacao (Vector<Integer> metade, Integer threadId) throws Exception {
        if (metade==null)
            throw new Exception ("Vetor ausente");

        if (threadId==null)
            throw new Exception ("Valor do id ausente");

        this.metade = metade;
        this.threadId = threadId;
    }

    public Integer getPosicaoEncontrada() {
        return posicaoEncontrada;
    }

    public Integer getThreadId() {
        return this.threadId;
    }

    public void run() {

    }
}

