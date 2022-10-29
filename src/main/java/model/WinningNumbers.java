package model;

import exception.DuplicationLottoNumbersException;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final String WINNING_LOTTO_SPLIT_DELIMETER = ",";

    private final String DUPLICATION_LOTTO_NUMBERS_ERROR_MESSSAGE = "중복된 숫자가 없어야 합니다.";

    private LottoNumbers lottoNumbers;

    public WinningNumbers(String winningLottoNumbers) {
        String[] splitNumbers = winningLottoNumbers.split(WINNING_LOTTO_SPLIT_DELIMETER);
        Set<LottoNumber> numbers = Arrays.stream(splitNumbers)
                .map( (lottoNumber) -> Integer.parseInt( lottoNumber.trim() ) )
                .distinct()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        validCheck(numbers.size(), splitNumbers.length);
        this.lottoNumbers = new LottoNumbers(numbers);
    }

    private void validCheck(int winningNumbersSize, int inputWinnigNumbersSize) {
        if (!isContainDuplicationNumber(winningNumbersSize, inputWinnigNumbersSize)) {
            throw new DuplicationLottoNumbersException(String.format(DUPLICATION_LOTTO_NUMBERS_ERROR_MESSSAGE));
        }
    }

    private boolean isContainDuplicationNumber(int winningNumbersSize, int inputWinnigNumbersSize) {
        if (winningNumbersSize == inputWinnigNumbersSize) {
            return true;
        }

        return false;
    }

    public int match( LottoNumbers compareLottoNumbers ) {
        return lottoNumbers.match(compareLottoNumbers);
    }
}
