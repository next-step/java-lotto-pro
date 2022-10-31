package step3.strategy;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static step3.domain.Lotto.*;
import static step3.domain.LottoNumber.MAX_NUMBER;
import static step3.domain.LottoNumber.MIN_NUMBER;

public class AutoLottoNumberStrategy implements LottoNumberStrategy{
    @Override
    public List<Integer> generateNumbers() {
        validateRange(MIN_NUMBER, MAX_NUMBER);
        validateCount(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);

        List<Integer> numbers = new ArrayList<>();
        for(int i = MIN_NUMBER; i<=MAX_NUMBER; i++){
            numbers.add(i);
        }
        shuffle(numbers);
        return numbers.subList(0, NUMBER_COUNT);
    }

    public void validateRange(int min, int max) {
        if(min > max){
            throw new IllegalArgumentException("최소 최대 범위가 옳바르지 않습니다.");
        }
    }

    public void validateCount(int min, int max, int count) {
        if(max - min + 1 < count){
            throw new IllegalArgumentException("생성하고자 하는 원소의 갯수가 범위 내 원소의 갯수보다 많습니다.");
        }
    }
}
