package lotto.domain;

import lotto.cons.ErrorMessageConst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    List<LottoNumber> lottoNumbers = new ArrayList<>();

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        for (int number : numbers) {
            LottoNumber lottoNumber = new LottoNumber(number);
            validateNumberUnique(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        Collections.sort(lottoNumbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_INVALID_LOTTO_SIZE, LOTTO_NUMBERS_SIZE)
            );
        }
    }

    private void validateNumberUnique(LottoNumber number) {
        if(lottoNumbers.contains(number)){
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_INVALID_LOTTO_UNIQUE);
        }
    }

    public List<Integer> lottoNumbers(){
        return lottoNumbersToIntegerList(lottoNumbers);
    }

    private List<Integer> lottoNumbersToIntegerList(List<LottoNumber> lottoNumbers) {
        List<Integer> result = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            result.add(lottoNumber.getNumber());
        }
        return result;
    }

    public int countMatchedNumbers(Lotto anotherLotto) {
        return (int) lottoNumbers.stream()
                .filter(anotherLotto.lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        List<Integer> integers = lottoNumbersToIntegerList(lottoNumbers);
        return integers.toString();
    }
}
