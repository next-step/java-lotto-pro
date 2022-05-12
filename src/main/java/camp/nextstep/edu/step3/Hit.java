package camp.nextstep.edu.step3;

public enum Hit {
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    ALL(6, 2000000000);

    private final int count;
    private final int prizeMoney;

    Hit(int count, int prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", this.count, this.prizeMoney);
    }
}
