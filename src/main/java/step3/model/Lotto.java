package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step3.constant.Constant.MIN_LOTTO_NUMBER;
import static step3.constant.Constant.MAX_LOTTO_NUMBER;
import static step3.constant.Constant.ZERO;
import static step3.constant.Constant.LOTTO_NUMBER_LENGTH;
public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public void generateLotto() {
        lottoNumbers = generateRandomNumbers();
    }

    public List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber>  rangeNumbers = setRangeNumbers();
        Collections.shuffle(rangeNumbers);

        this.lottoNumbers = rangeNumbers.subList(ZERO, LOTTO_NUMBER_LENGTH);
        return lottoNumbers;
    }

    private List<LottoNumber> setRangeNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        for(int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
