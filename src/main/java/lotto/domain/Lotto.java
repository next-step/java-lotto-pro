package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    List<LottoNumber> lottoNumbers = new ArrayList<>();

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
            throw new IllegalArgumentException("[ERROR] Lotto의 숫자는 6개여야 합니다.");
        }
    }

    private void validateNumberUnique(LottoNumber number) {
        if(lottoNumbers.contains(number)){
            throw new IllegalArgumentException("[ERROR] Lotto의 숫자는 중복이 불가합니다.");
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

    @Override
    public String toString() {
        List<Integer> integers = lottoNumbersToIntegerList(lottoNumbers);
        return integers.toString();
    }
}
