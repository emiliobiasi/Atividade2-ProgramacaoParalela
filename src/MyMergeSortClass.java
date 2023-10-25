import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class MyMergeSortClass {

    public static void myMergeSort(Vector<Integer> vector, AtomicInteger processadores) {
        if (vector.size() > 1) {
            if (processadores.getAndDecrement() > 0) {
                int mid = vector.size() / 2;
                Vector<Integer> esquerda = new Vector<>(vector.subList(0, mid));
                Vector<Integer> direita = new Vector<>(vector.subList(mid, vector.size()));

                System.out.println("Processadores disponíveis: " + processadores.get());
                Thread threadEsquerda = new MergeSortThread(esquerda, processadores);
                Thread threadDireita = new MergeSortThread(direita, processadores);

                threadEsquerda.start();
                threadDireita.start();

                try {
                    threadEsquerda.join();
                    threadDireita.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                merge(vector, esquerda, direita);
                processadores.incrementAndGet();
            } else {
                List<Integer> sublistEsquerda = vector.subList(0, vector.size() / 2);
                List<Integer> sublistDireita = vector.subList(vector.size() / 2, vector.size());

                Vector<Integer> esquerda = new Vector<>(sublistEsquerda);
                Vector<Integer> direita = new Vector<>(sublistDireita);

                myMergeSort(esquerda, processadores);
                myMergeSort(direita, processadores);

                merge(vector, esquerda, direita);
            }
        }
    }

    public static void merge(Vector<Integer> vector, Vector<Integer> esquerda, Vector<Integer> direita) {
        int i = 0, j = 0, k = 0;
        while (i < esquerda.size() && j < direita.size()) {
            if (esquerda.get(i) < direita.get(j)) {
                vector.set(k++, esquerda.get(i++));
            } else {
                vector.set(k++, direita.get(j++));
            }
        }

        while (i < esquerda.size()) {
            vector.set(k++, esquerda.get(i++));
        }

        while (j < direita.size()) {
            vector.set(k++, direita.get(j++));
        }
    }

}
