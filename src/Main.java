import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

// Gian Vitor Dutra   21001048
// Emílio José Biasi   21006674
public class Main {
    public static void main(String[] args) {
        try
        {
            //int tamVetor = Menu.mainMenu();
            int tamVetor = 100;
            System.out.println("Tamanho do Vetor: " + tamVetor);

            Vector<Integer> vetorGigante = new Vector<>(tamVetor);
            for (int i = 0; i < tamVetor; i++) {
                vetorGigante.add(i);
            }

            Collections.shuffle(vetorGigante);

            System.out.println("Vetor desordenado: " + vetorGigante);


            int numProcessadores = Programa.numProcessadores();
            AtomicInteger processadores = new AtomicInteger(numProcessadores);
            System.out.println("Numero total de processadores deste computador: " + numProcessadores);

            System.out.println("Chamando método merge sort: ");

            MyMergeSortClass.myMergeSort(vetorGigante, processadores);

            System.out.println("Vetor ordenado: " + vetorGigante);

        }
        catch (Exception erro)
        {}

    }
}
