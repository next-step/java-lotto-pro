package lotto.domain;

public class BonusBall {

    private final Number number;

    public BonusBall(String number) {
        this.number = new Number(Integer.parseInt(number));
    }

    public Number getNumber() {
        return number;
    }
}
