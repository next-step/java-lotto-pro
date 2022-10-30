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

    public double divide(Integer total) {
        return Math.floor(total /(double)this.won * 100)/100;
    }

    public int calLottoTicketCount(int lottoFee) {
        validate(lottoFee);
        return won / lottoFee;
    }

    private void validate(int lottoFee) {
        if(won < lottoFee){
            throw new IllegalArgumentException("로또를 구매할 수 없습니다");
        }
    }
}
