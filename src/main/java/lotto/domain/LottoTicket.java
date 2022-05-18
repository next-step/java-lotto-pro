package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LottoTicket {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String ERROR_MESSAGE_NUMBER_SIZE = LOTTO_NUMBER_SIZE + "개의 번호를 입력해주세요.";
    private static final String ERROR_MESSAGE_NOT_UNIQUE = "중복되는 번호가 존재합니다.";
    private static final String ERROR_MESSAGE_NOT_UNIQUE_BONUS_NUMBER = "보너스볼은 당첨 번호와 중복될 수 없습니다.";

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(String input) {
        validate(input);
        List<String> lottoNumberList = Arrays.asList(input.split(LOTTO_NUMBER_DELIMITER));
        this.lottoNumbers = mapLottoNumbers(lottoNumberList);
    }

    public LottoRank rank(LottoTicket winningNumbers, LottoNumber bonusNumber) {
        return LottoRank.rank(matchCount(winningNumbers), contains(bonusNumber));
    }

    public int matchCount(LottoTicket winningNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private List<LottoNumber> mapLottoNumbers(List<String> lottoNumberList) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : lottoNumberList) {
            LottoNumber lottoNumber = new LottoNumber(number);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private void validate(String input) {
        validateNullOrEmpty(input);
        validateSize(input);
        validateUnique(input);
    }

    private void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_SIZE);
        }
    }

    private void validateSize(String input) {
        if (input.split(LOTTO_NUMBER_DELIMITER).length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_SIZE);
        }
    }

    private void validateUnique(String input) {
        List<String> lottoNumberList = Arrays.asList(input.split(LOTTO_NUMBER_DELIMITER));
        HashSet<String> distinctLottoNumberList = new HashSet<>(lottoNumberList);
        if (lottoNumberList.size() != distinctLottoNumberList.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_UNIQUE);
        }
    }

    public void validateUniqueBonusNumber(LottoNumber bonusNumber) {
        if (contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_UNIQUE_BONUS_NUMBER);
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
