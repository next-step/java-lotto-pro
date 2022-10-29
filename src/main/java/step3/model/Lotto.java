package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step3.constant.Constant.MIN_LOTTO_NUMBER;
import static step3.constant.Constant.MAX_LOTTO_NUMBER;
import static step3.constant.Constant.ZERO;
import static step3.constant.Constant.LOTTO_NUMBER_LENGTH;
import static step3.constant.Constant.COMMA;
public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
    public void generateLotto() {
        lottoNumbers = generateRandomNumbers();
    }

    public List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber> rangeNumbers = createLottoNumberList(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        Collections.shuffle(rangeNumbers);

        this.lottoNumbers = rangeNumbers.subList(ZERO, LOTTO_NUMBER_LENGTH);
        return lottoNumbers;
    }

    public void setLastWeekWinner(String[] afterNumbers) {
        this.lottoNumbers = createLottoNumberList(ZERO, afterNumbers.length);

    }

    private List<LottoNumber> createLottoNumberList(int startValue, int length) {
        List<LottoNumber> numbers = new ArrayList<>();
        for(int i = startValue; i <= length; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}
