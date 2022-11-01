package step3.domain;

import step3.enums.Rule;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoNumber {

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
        return Rule.TOTAL_START_NUMBER.getRange() <= lottoNumber
                && lottoNumber <= Rule.TOTAL_END_NUMBER.getRange() ;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

}



