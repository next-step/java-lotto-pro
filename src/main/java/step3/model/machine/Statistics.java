package step3.model.machine;

import step3.model.value.ErrMsg;
import step3.model.value.Rule;

public class Statistics {
    private final long totalPrice;
    private final long totalPrize;

    public Statistics(long totalPrice, long totalPrize) {
        this.totalPrice = totalPrice;
        this.totalPrize = totalPrize;
    }

    public double getStatisticResult(){
        if (totalPrice<0 || totalPrize<0){
            throw new IllegalArgumentException(ErrMsg.WRONG_STATISTICS_INPUT);
        }
        if (totalPrice == 0) {
            return 0;
        }
        return (double) this.totalPrize / this.totalPrice;
    }
}
