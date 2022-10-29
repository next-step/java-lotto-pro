package step3.domain;

public class Payment {
    private static final int LOTTO_PRICE = 1000;
    private final int payment;
    
    public Payment(int payment) {
        this.payment = checkNegative(payment);
    }
    
    public int getPayment() {
        return this.payment;
    }
    
    private int checkNegative(int value){
        return Math.max(value, 0);
    }
    
    public int getLottoCount() {
        return this.payment / LOTTO_PRICE;
    }
}
