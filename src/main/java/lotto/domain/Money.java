package lotto.domain;

public class Money {
    private final int won;

    private Money(int won) {
        this.won = won;
    }

    public static Money of(int won) {
        if(won <= 0){
            throw new RuntimeException("돈은 0보다 큰 정수여야 합니다");
        }
        return new Money(won);
    }

    public int getValue() {
        return won;
    }

    public double divide(Integer total) {
        return Math.floor(total /(double)this.won * 100)/100;
    }
}
