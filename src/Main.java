import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        try
        {
            int tamVetor = Menu.mainMenu();
            //int tamVetor = 20;
            System.out.println("Tamanho do Vetor: " + tamVetor);

            // populando
            Vector<Integer> vetorGigante = new Vector<>(tamVetor);
            for (int i = 0; i < tamVetor; i++) {
                vetorGigante.add(i);
            }
            // embaralhando
            Collections.shuffle(vetorGigante);

            System.out.println("Vetor desordenado: " + vetorGigante);

            int numProcessadores = Programa.numProcessadores();
            AtomicInteger processadores = new AtomicInteger(numProcessadores);


            MyMergeSortClass.myMergeSort(vetorGigante, processadores);

            System.out.println("Vetor ordenado: " + vetorGigante);

//            ThreadDeOrdenacao[] threads = new ThreadDeOrdenacao[numeroDeProcessadores.getNumeroDeProcessadores()];
//            numeroDeProcessadores.diminuiProcessador();
//            MergeSortThread thread = new MergeSortThread(vetorGigante);
//            thread.start();

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
