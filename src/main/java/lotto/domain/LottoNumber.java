package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private final Integer number;

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber of(Integer number) {
        if(Objects.isNull(number) || number <= 0 || number > 45){
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
}
