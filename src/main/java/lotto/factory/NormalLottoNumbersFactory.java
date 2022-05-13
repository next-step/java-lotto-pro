package lotto.factory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.NormalLottoNumbers;

public class NormalLottoNumbersFactory implements LottoNumbersFactory{
    private static final int LOTTO_NUMBERS_SIZE = 6;
    @Override
    public LottoNumbers createLottoNumbers(List<Integer> numbers) {
        checkNumbers(numbers);
        LottoNumbers lottoNumbers = new NormalLottoNumbers();
        numbers.stream().map(LottoNumber::new).forEach((lottoNumber)->{
            lottoNumbers.add(lottoNumber);
        });
        return lottoNumbers;
    }

    private void checkNumbers(List<Integer> numbers){
        Set<Integer> distinctNubers = new HashSet<>(numbers);
        if(distinctNubers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("서로 다른 " + LOTTO_NUMBERS_SIZE + "개의 숫자가 필요합니다.");
        }
    }
}
