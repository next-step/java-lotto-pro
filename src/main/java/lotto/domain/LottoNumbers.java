package lotto.domain;

import lotto.message.InputMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    public static final int LOTTO_DIGITS = 6;
    private final List<Integer> lottoNumbers;

    public LottoNumbers(String[] lottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        initializeLottoNumbers(lottoNumbers);
        validate();
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private void validate() {
        validateDigits(this.lottoNumbers);
        validateUnique(this.lottoNumbers);
    }

    private void validateUnique(List<Integer> lottoNumbers) {
        Set<Integer> numbers = new HashSet<>(lottoNumbers);
        if (numbers.size() != LOTTO_DIGITS) {
            throw new IllegalArgumentException(InputMessage.INVALID_LOTTO_UNIQUE);
        }
    }

    private void validateDigits(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_DIGITS) {
            throw new IllegalArgumentException(InputMessage.INVALID_LOTTO_DIGITS);
        }
    }

    private void initializeLottoNumbers(String[] lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            this.lottoNumbers.add(new LottoNumber(lottoNumber).getLottoNumber());
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int calculateMatchCount(HashSet<Integer> winningNumberSet) {
        HashSet<Integer> copyWinningNumber = new HashSet<>(winningNumberSet);
        for (int lottoNumber : lottoNumbers) {
            copyWinningNumber.remove(lottoNumber);
        }

        return LOTTO_DIGITS - copyWinningNumber.size();
    }
}
