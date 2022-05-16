package lotto_auto.model;

import java.util.*;

import java.util.stream.Collectors;

public class LottoNumbers {
    private final Set<LottoNumber> lottoNumberSet;

    public static final int VALID_SIZE = 6;
    public static final String LOTTO_DELIMITER = ", ";

    public static final String NOT_MATCHED_NUMBER_SIZE = "[ERROR] 로또 번호는 6개의 숫자가 필요합니다.";
    public static final String EXIST_DUPLICATE_VALUE = "[ERROR] 로또 번호는 중복 숫자가 존재할 수 없습니다.";
    public static final String NOT_NUMBER = "[ERROR] 로또의 번호에 숫자 이외의 값이 존재합니다.";

    public LottoNumbers(List<LottoNumber> numberList) {
        this.lottoNumberSet = Collections.unmodifiableSet(new HashSet<>(numberList));
        checkNumbersSize();
    }

    public LottoNumbers(String stringNumbers) {
        try {
            this.lottoNumberSet =
                    Collections.unmodifiableSet(Arrays.stream(stringNumbers.split(LOTTO_DELIMITER))
                            .map(Integer::parseInt)
                            .map(LottoNumber::new)
                            .collect(Collectors.toSet()));

            checkNumbersSize();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private void checkNumbersSize() {
        if (!(lottoNumberSet.size() == VALID_SIZE)) {
            throw new IllegalArgumentException(NOT_MATCHED_NUMBER_SIZE);
        }
    }

    public Set<LottoNumber> getLottoNumberSet() {
        return lottoNumberSet;
    }

    public int countSameLottoNumber(LottoNumbers numbers) {
        return (int) this.lottoNumberSet
                .stream()
                .filter(lottoNumber -> numbers.getLottoNumberSet().contains(lottoNumber)).count();
    }
}
