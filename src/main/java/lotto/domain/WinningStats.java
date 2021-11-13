package lotto.domain;

public class WinningStats {

    private final int first;
    // private final int second;
    private final int third;
    private final int fourth;
    private final int fifth;

    public WinningStats(Lottos lottos, WinningNumbers winningNumbers) {
        int first = 0;
        int third = 0;
        int fourth = 0;
        int fifth = 0;

        this.first = first;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public int getFirst() {
        return first;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }
}
