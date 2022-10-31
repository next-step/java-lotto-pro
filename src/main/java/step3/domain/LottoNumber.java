package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LottoNumber {

    public static final ArrayList<Integer> RANGE = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                                                            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                                                                            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                                                                            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                                                                            41, 42, 43, 44, 45));

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if(!isValid(lottoNumber)){
            throw new IllegalArgumentException("로또 숫자 범위가 아닙니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private boolean isValid(int lottoNumber){
        return RANGE.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber+"";
    }

}



