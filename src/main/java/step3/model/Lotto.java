package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step3.constant.Constant.*;
import static step3.constant.Message.*;
import static step3.utils.CommonUtils.*;

public class Lotto {
    private List<LottoNumber> lottoNumbers;
    private LottoNumber bonusNumber;

    public Lotto() {
        lottoNumbers = generateRandomNumbers();
    }

    public Lotto(List<LottoNumber> numbers) {
        lottoNumbers = numbers;
    }

    public Lotto(String[] numbers) {
        List<LottoNumber> list = new ArrayList<>();
        for (String str : numbers) {
            list.add(new LottoNumber(commonStringToNumber(str)));
        }
        this.lottoNumbers = list;
    }

    public Lotto(String[] numbers, int number) {
        List<LottoNumber> list = new ArrayList<>();
        for (String str : numbers) {
            list.add(new LottoNumber(commonStringToNumber(str)));
        }
        this.lottoNumbers = list;
        this.bonusNumber = new LottoNumber(number);
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber> rangeNumbers = createLottoNumberList(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        Collections.shuffle(rangeNumbers);
        this.lottoNumbers = rangeNumbers.subList(ZERO, LOTTO_NUMBER_LENGTH);
        return lottoNumbers;
    }

    private List<LottoNumber> createLottoNumberList(int startValue, int length) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = startValue; i <= length; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

    public String[] validateLastWeekWinner(String beforeNumbers) {
        commonCheckEmpty(beforeNumbers);
        String[] afterNumbers = changeBeforeNumbers(beforeNumbers);
        validateLength(afterNumbers);
        validateNumberType(afterNumbers);
        validateSameNumber(afterNumbers);

        return afterNumbers;
    }

    private String[] changeBeforeNumbers(String beforeNumbers) {
        beforeNumbers = beforeNumbers.replaceAll(SPACE, "");
        return beforeNumbers.split(COMMA);
    }

    private void validateLength(String[] afterNumbers) {
        if (afterNumbers.length != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(UNVALID_LOTTO_NUMBER_LENGTH);
        }
    }

    private void validateNumberType(String[] afterNumbers) {
        for (int i = 0; i < afterNumbers.length; i++) {
            commonStringToNumber(afterNumbers[i]);
        }
    }

    private void validateSameNumber(String[] afterNumbers) {
        List<String> StirngNumberList = new ArrayList<>();
        for (String strNumber : afterNumbers) {
            isStringContainInList(StirngNumberList, strNumber);
            StirngNumberList.add(strNumber);
        }
    }

    private void isStringContainInList(List<String> list, String target) {
        if (isListContainsString(list, target)) {
            throw new IllegalArgumentException(SMAE_LOTTO_NUMBER);
        }
    }

    public boolean isMatchNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }
}
