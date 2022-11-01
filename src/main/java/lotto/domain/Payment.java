package lotto.domain;

public class Payment {

    private int payment;

    public Payment(String input) {
        this.payment = Integer.parseInt(input);
    }

    public int getPayment() {
        return this.payment;
    }

}
