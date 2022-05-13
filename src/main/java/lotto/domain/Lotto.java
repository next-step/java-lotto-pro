package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MAX_LOTTO_NUMBERS_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final String BLANK_FORMAT = " ";
    private static final String REPLACE_FORMAT = "";
    private static final String SPLIT_DELIMITER = ",";
    private static final String RANGE_ERROR_MESSAGE = "로또 번호는 1 ~ 45 사이의 값이어야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "로또 번호들은 중복이 되면 안됩니다.";
    private static final String SIZE_ERROR_MESSAGE = "로또 번호는 6개만 가능합니다.";

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        validateRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String winLottoNumbers) {
        this(Arrays.stream(winLottoNumbers.replace(BLANK_FORMAT, REPLACE_FORMAT).split(SPLIT_DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList()));
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != MAX_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != MAX_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            validateNumberRange(lottoNumber);
        }
    }

    private void validateNumberRange(Integer lottoNumber) {
        if (lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return "" + lottoNumbers + "";
    }

    public Rank match(Lotto winLotto) {
        int matchCount = (int) lottoNumbers.stream()
                .filter(number -> winLotto.getLottoNumbers().contains(number))
                .count();
        return Rank.valueOf(matchCount);
    }
}
