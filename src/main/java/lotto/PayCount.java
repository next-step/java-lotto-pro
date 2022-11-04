package lotto;

public class PayCount {

    private static final int INFINITE = -1;
    private int count;

    public PayCount() {
        this(INFINITE);
    }

    public PayCount(int count) {
        this.count = count;
    }

    public boolean remain() {
        if (count == INFINITE) {
            return true;
        }
        return count-- > 0;
    }
}
