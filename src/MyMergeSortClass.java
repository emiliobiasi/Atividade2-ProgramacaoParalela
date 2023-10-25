import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class MyMergeSortClass {

    public static void myMergeSort(Vector<Integer> vector, AtomicInteger processadores) {
        if (vector.size() > 1) {
            if (processadores.getAndDecrement() > 0) {
                int mid = vector.size() / 2;
                Vector<Integer> left = new Vector<>(vector.subList(0, mid));
                Vector<Integer> right = new Vector<>(vector.subList(mid, vector.size()));

                System.out.println(processadores.get());
                Thread leftThread = new MergeSortThread(left, processadores);
                Thread rightThread = new MergeSortThread(right, processadores);

                leftThread.start();
                rightThread.start();

                try {
                    leftThread.join();
                    rightThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                merge(vector, left, right);
                processadores.incrementAndGet(); // Libera um processador
            } else {
                List<Integer> leftSublist = vector.subList(0, vector.size() / 2);
                List<Integer> rightSublist = vector.subList(vector.size() / 2, vector.size());

                Vector<Integer> left = new Vector<>(leftSublist);
                Vector<Integer> right = new Vector<>(rightSublist);

                myMergeSort(left, processadores);
                myMergeSort(right, processadores);

                merge(vector, left, right);
            }
        }
    }

    public static void merge(Vector<Integer> vector, Vector<Integer> left, Vector<Integer> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                vector.set(k++, left.get(i++));
            } else {
                vector.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            vector.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            vector.set(k++, right.get(j++));
        }
    }

}
