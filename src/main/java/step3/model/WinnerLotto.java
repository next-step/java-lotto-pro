package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step3.constant.Constant.Common.*;
import static step3.constant.Message.Error.*;
import static step3.utils.CommonUtils.*;

public class WinnerLotto extends Lotto{
    private LottoNumber bonusNumber;

//    public WinnerLotto(String[] numbers, String StringNumber) {
//        super(list);
//        List<LottoNumber> list = new ArrayList<>();
//        for (String str : numbers) {
//            list.add(new LottoNumber(commonStringToNumber(str)));
//        }
//
//        super(list);
//        Lotto.lottoNumbers = list;
//        this.bonusNumber = new LottoNumber(validateBonusNumber(StringNumber));
//    }

    public WinnerLotto(List<LottoNumber> list, String StringNumber) {
        super(list);
        this.bonusNumber = new LottoNumber(validateBonusNumber(StringNumber));
    }

    public WinnerLotto() {

    }

    public WinnerLotto(List<LottoNumber> list) {
        super(list);
    }

    //    public List<LottoNumber> getNumbers() {
//        return lottoNumbers;
//    }
//
    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
//
//    public List<LottoNumber> generateRandomNumbers() {
//        List<LottoNumber> rangeNumbers = createLottoNumberList(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
//        Collections.shuffle(rangeNumbers);
//        this.lottoNumbers = rangeNumbers.subList(ZERO, LOTTO_NUMBER_LENGTH);
//        return lottoNumbers;
//    }
//
//    private List<LottoNumber> createLottoNumberList(int startValue, int length) {
//        List<LottoNumber> numbers = new ArrayList<>();
//        for (int i = startValue; i <= length; i++) {
//            numbers.add(new LottoNumber(i));
//        }
//        return numbers;
//    }
//
//    public String[] validateLastWeekWinner(String beforeNumbers) {
//        commonCheckEmpty(beforeNumbers);
//        String[] afterNumbers = changeBeforeNumbers(beforeNumbers);
//        validateLength(afterNumbers);
//        validateNumberType(afterNumbers);
//        validateSameNumber(afterNumbers);
//        return afterNumbers;
//    }
//
    private int validateBonusNumber(String stringNumber) {
        commonCheckEmpty(stringNumber);
        int number = commonStringToNumber(stringNumber);
        checkWinningNumbersContainBonusNumber(number);
        return number;
    }

    private void checkWinningNumbersContainBonusNumber(int number) {
        if(isMatchNumber(new LottoNumber(number))) {
            throw new IllegalArgumentException(SMAE_BONUS_NUMBER);
        }
    }
//
//    private String[] changeBeforeNumbers(String beforeNumbers) {
//        beforeNumbers = beforeNumbers.replaceAll(SPACE, "");
//        return beforeNumbers.split(COMMA);
//    }
//
//    private void validateLength(String[] afterNumbers) {
//        if (afterNumbers.length != LOTTO_NUMBER_LENGTH) {
//            throw new IllegalArgumentException(UNVALID_LOTTO_NUMBER_LENGTH);
//        }
//    }
//
//    private void validateNumberType(String[] afterNumbers) {
//        for (int i = 0; i < afterNumbers.length; i++) {
//            commonStringToNumber(afterNumbers[i]);
//        }
//    }
//
//    private void validateSameNumber(String[] afterNumbers) {
//        List<String> StirngNumberList = new ArrayList<>();
//        for (String strNumber : afterNumbers) {
//            isStringContainInList(StirngNumberList, strNumber);
//            StirngNumberList.add(strNumber);
//        }
//    }
//
//    private void isStringContainInList(List<String> list, String target) {
//        if (isListContainsString(list, target)) {
//            throw new IllegalArgumentException(SMAE_LOTTO_NUMBER);
//        }
//    }
//
//    public boolean isMatchNumber(LottoNumber number) {
//        return lottoNumbers.contains(number);
//    }
}
