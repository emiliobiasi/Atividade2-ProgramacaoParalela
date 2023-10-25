public class Processadores {
    private int value;

    public Processadores(int initialValue) {
        this.value = initialValue;
    }

    public synchronized int get() {
        return value;
    }

    public synchronized int getAndDecrement() {
        int oldValue = value;
        value--;
        return oldValue;
    }

    public synchronized int getAndIncrement() {
        int oldValue = value;
        value++;
        return oldValue;
    }
}