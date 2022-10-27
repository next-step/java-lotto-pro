package lotto.domain;

public class Money {
    private final int won;

    private Money(int won) {
        this.won = won;
    }

    public static Money of(int won) {
        if(won < 0){
            throw new RuntimeException("돈은 0이상의 정수여야 합니다");
        }
        return new Money(won);
    }

    public int getValue() {
        return won;
    }
}
