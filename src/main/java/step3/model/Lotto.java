package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step3.constant.Constant.Number.*;
import static step3.constant.Constant.Lotto.*;
public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = generateRandomNumbers();
    }

    public Lotto(String[] numbers) {
        List<LottoNumber> list = new ArrayList<>();
        for(String str : numbers) {
            list.add(new LottoNumber(LottoGenerator.commonStringToNumber(str)));
        }
        this.lottoNumbers = list;
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    public List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber> rangeNumbers = createLottoNumberList(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        Collections.shuffle(rangeNumbers);

        this.lottoNumbers = rangeNumbers.subList(ZERO, LOTTO_NUMBER_LENGTH);
        return lottoNumbers;
    }

    private List<LottoNumber> createLottoNumberList(int startValue, int length) {
        List<LottoNumber> numbers = new ArrayList<>();
        for(int i = startValue; i <= length; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}
