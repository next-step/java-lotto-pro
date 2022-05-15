package lotto.domain;

import java.util.Objects;

public class LottoStatic {
    private static final int THREE_WINNING_AMOUNT = 5000;
    private static final int FOUR_WINNING_AMOUNT = 50000;
    private static final int FIVE_WINNING_AMOUNT = 1500000;
    private static final int SIX_WINNING_AMOUNT = 2000000000;

    private int three;
    private int four;
    private int five;
    private int six;
    private double profitLate;

    public LottoStatic() {
    }

    public LottoStatic(int three, int four, int five, int six) {
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
    }

    public double getProfitLate() {
        return this.profitLate;
    }

    public void calculatorCount(int count) {
        if (count == 3) this.three++;
        if (count == 4) this.four++;
        if (count == 5) this.five++;
        if (count == 6) this.six++;
    }

    public void calculatorProfitLate(int amount) {
        double profit = 0;
        profit += this.three * THREE_WINNING_AMOUNT;
        profit += this.four * FOUR_WINNING_AMOUNT;
        profit += this.five * FIVE_WINNING_AMOUNT;
        profit += this.six * SIX_WINNING_AMOUNT;

        double profitLate = Math.floor((profit / (double)amount) * 100) / 100.0;
        this.profitLate = profitLate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStatic lottoStatic = (LottoStatic) o;

        if (three != lottoStatic.three) return false;
        if (four != lottoStatic.four) return false;
        if (five != lottoStatic.five) return false;
        if (six != lottoStatic.six) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(three, four, five, six);
    }
}
