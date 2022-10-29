package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final Integer number;

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber of(Integer number) {
        if(Objects.isNull(number) || number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER){
            throw new RuntimeException("로또 번호는 1~45 여야 함");
        }
        return new LottoNumber(number);
    }

    public int getValue(){
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.getValue() - o.getValue();
    }

    @Override
    public String toString() {
        return this.number.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
