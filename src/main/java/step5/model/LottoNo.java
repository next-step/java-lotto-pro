package step5.model;

import step5.service.LottoGenerator;

public class LottoNo implements Comparable<LottoNo> {

    private final int number;

    public LottoNo(int number) {
        isNotBetween(number);
        this.number = number;
    }

    private void isNotBetween(int number) {
        if (number < LottoGenerator.LOTTO_START_NUMBER || number > LottoGenerator.LOTTO_END_NUMBER) {
            throw new RuntimeException("로또범위의 숫자가 아닙니다.");
        }
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNo) {
            return ((LottoNo) obj).number == number;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNo o) {
        return this.number - o.number;
    }
}
