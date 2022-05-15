package lotto.domain;

import java.util.Objects;

public class LottoStatistic {
    private static final int THREE_WINNING_AMOUNT = 5000;
    private static final int FOUR_WINNING_AMOUNT = 50000;
    private static final int FIVE_WINNING_AMOUNT = 1500000;
    private static final int SIX_WINNING_AMOUNT = 2000000000;

    private int three;
    private int four;
    private int five;
    private int six;
    private double profitLate;

    public LottoStatistic() {
    }

    public LottoStatistic(int three, int four, int five, int six) {
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

    public String toResultString() {
        StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (" + THREE_WINNING_AMOUNT + "원)- " + this.three + "개");
        sb.append("\n4개 일치 (" + FOUR_WINNING_AMOUNT +"원)- " + this.four + "개");
        sb.append("\n5개 일치 (" + FIVE_WINNING_AMOUNT + "원)- " + this.five + "개");
        sb.append("\n6개 일치 (" + SIX_WINNING_AMOUNT + "원)- " + this.six + "개");
        sb.append("\n총 수익률은 " + this.profitLate + "입니다.");

        if (this.profitLate < 1) {
            sb.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStatistic lottoStatistic = (LottoStatistic) o;

        if (three != lottoStatistic.three) return false;
        if (four != lottoStatistic.four) return false;
        if (five != lottoStatistic.five) return false;
        if (six != lottoStatistic.six) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(three, four, five, six);
    }
}
