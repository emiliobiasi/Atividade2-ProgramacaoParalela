import java.util.Collections;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try
        {
            int tamVetor = Menu.mainMenu();
            System.out.println("Tamanho do Vetor: " + tamVetor);

            Vector<Integer> vetorGigante = new Vector<>(tamVetor);
            for (int i = 0; i < tamVetor; i++) {
                vetorGigante.add(i);
            }
            Collections.shuffle(vetorGigante);

            int numeroDeProcessadores = Programa.numProcessadores();
            int numeroDeThreads = 0;

            ThreadDeOrdenacao[] threads = new ThreadDeOrdenacao[numeroDeProcessadores];

            for (int i = 0; i < numeroDeThreads; i++) {

                threads[i] = new ThreadDeOrdenacao(vetorGigante, i);

            }

            for (ThreadDeOrdenacao thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (ThreadDeOrdenacao threadDeBusca : threads) {
                Integer posicaoEncontrada = threadDeBusca.getPosicaoEncontrada();
                Integer threadQueEncontrou = threadDeBusca.getThreadId();
                if (posicaoEncontrada == null) {
                    System.out.println("valor NÃO ENCONTRADO pela thread: " + threadQueEncontrou);

                } else {
                    System.out.println("Valor ENCONTRADO na posição " + posicaoEncontrada + " pela thread: " + threadQueEncontrou);
                }
            }
        }
        catch (Exception erro)
        {}

    }
}
