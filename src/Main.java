import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try
        {
            //int tamVetor = Menu.mainMenu();
            int tamVetor = 20;
            System.out.println("Tamanho do Vetor: " + tamVetor);

            Integer[] vetorGigante = new Integer[tamVetor];
            for (int i = 0; i < tamVetor; i++) {
                vetorGigante[i] = i;
            }
            List<Integer> lista = new ArrayList<>();
            Collections.addAll(lista, vetorGigante);

            // Embaralhe a lista
            Collections.shuffle(lista);

            // Converta a lista embaralhada de volta para um array
            lista.toArray(vetorGigante);

            System.out.println(vetorGigante);


            Processadores numeroDeProcessadores = new Processadores( Programa.numProcessadores());
            int numeroDeThreads = 0;

            //ThreadDeOrdenacao[] threads = new ThreadDeOrdenacao[numeroDeProcessadores.getNumeroDeProcessadores()];
            numeroDeProcessadores.diminuiProcessador();
            ThreadDeOrdenacao thread = new ThreadDeOrdenacao(vetorGigante, numeroDeProcessadores);



            thread.start();



//            for (ThreadDeOrdenacao thread : threads) {
//                try {
//                    thread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            for (ThreadDeOrdenacao threadDeBusca : threads) {
//                Integer posicaoEncontrada = threadDeBusca.getPosicaoEncontrada();
//                Integer threadQueEncontrou = threadDeBusca.getThreadId();
//                if (posicaoEncontrada == null) {
//                    System.out.println("valor NÃO ENCONTRADO pela thread: " + threadQueEncontrou);
//
//                } else {
//                    System.out.println("Valor ENCONTRADO na posição " + posicaoEncontrada + " pela thread: " + threadQueEncontrou);
//                }
//            }
        }
        catch (Exception erro)
        {}

    }
}
