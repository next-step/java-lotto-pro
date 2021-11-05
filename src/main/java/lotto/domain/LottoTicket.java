package lotto.domain;

import static lotto.domain.LottoNumbersFactory.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final String WRONG_NUMBERS_SIZE_MESSAGE = "로또 번호는 6개만 가능합니다.";
    public static final String EXIST_DUPLICATE_NUMBER_MESSAGE = "중복된 번호가 존재합니다.";
    public static final String OUT_OF_RANGE_NUMBER_MESSAGE = "로또 숫자는 1~45 사이만 가능합니다.";
    public static final String NON_SORTED_NUMBERS_MESSAGE = "로또 번호가 정렬되어 있지 않습니다.";

    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        for (Integer lottoNumber : lottoNumbers) {
            validateRange(lottoNumber);
        }
        validateSorted(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(WRONG_NUMBERS_SIZE_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicatedNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(EXIST_DUPLICATE_NUMBER_MESSAGE);
        }
    }

    private void validateRange(Integer lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_MIN_RANGE || lottoNumber > LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_MESSAGE);
        }
    }

    private void validateSorted(List<Integer> lottoNumbers) {
        boolean isSorted = lottoNumbers.stream()
            .sorted()
            .collect(Collectors.toList())
            .equals(lottoNumbers);

        if (!isSorted) {
            throw new IllegalArgumentException(NON_SORTED_NUMBERS_MESSAGE);
        }
    }
}
