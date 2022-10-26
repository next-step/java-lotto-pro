package step3;


public class Calculator {
    private static final int LOTTO_PRICE = 1000;
    private final int payment;
    public Calculator(int money) {
        this.payment = checkNegative(money);
    }

    public int getLottoCount() {
        return this.payment / LOTTO_PRICE;
    }
    
    private int checkNegative(Integer value){
        if (value < 0) {
            return 0;
        }
        return value;
    }
}
