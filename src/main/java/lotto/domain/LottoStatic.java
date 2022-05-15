package lotto.domain;

public class LottoStatic {
    private int three;
    private int four;
    private int five;
    private int six;
    private double profitLate;

    public LottoStatic() {
    }

    public void calculator(int count) {
        if (count == 3) this.three++;
        if (count == 4) this.four++;
        if (count == 5) this.five++;
        if (count == 6) this.six++;
    }
}
