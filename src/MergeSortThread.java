import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

class MergeSortThread extends Thread {
    private Vector<Integer> vector;
    private AtomicInteger processadores;

    public MergeSortThread(Vector<Integer> vector, AtomicInteger processadores) {
        this.vector = vector;
        this.processadores = processadores;

    }

    @Override
    public void run() {
        if (vector.size() > 1) {
            MyMergeSortClass.myMergeSort(vector, processadores);
        }
    }
}