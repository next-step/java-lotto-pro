package step3.model;

import java.util.ArrayList;
import java.util.List;

import static step3.constant.Constant.MIN_LOTTO_NUMBER;
import static step3.constant.Constant.MAX_LOTTO_NUMBER;
public class Lotto {
    private List<LottoNumber> lottoNumbers;
    private List<LottoNumber> rangeNumbers;

    public void setLottoNumbers() {
        lottoNumbers = generateRandomNumbers();
    }

    private List<LottoNumber> generateRandomNumbers() {
        rangeNumbers = setRangeNumbers();



        return lottoNumbers;
    }

    private List<LottoNumber> setRangeNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        for(int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}
