package lotto_auto.model;

import java.util.*;

public class LottoNumbers {
    private final Set<LottoNumber> lottoNumberSet;

    public static final int VALID_SIZE = 6;

    public static final String NOT_MATCHED_NUMBER_SIZE = "[ERROR] 로또 번호는 6개의 숫자가 필요합니다.";
    public static final String EXIST_DUPLICATE_VALUE = "[ERROR] 로또 번호는 중복 숫자가 존재할 수 없습니다.";

    public LottoNumbers(Set<LottoNumber> numberList) {
        this.lottoNumberSet = Collections.unmodifiableSet(new HashSet<>(numberList));
        checkNumbersSize();
    }

    private void checkNumbersSize() {
        if (!(lottoNumberSet.size() == VALID_SIZE)) {
            throw new IllegalArgumentException(NOT_MATCHED_NUMBER_SIZE);
        }
    }

    public Set<LottoNumber> getLottoNumberSet() {
        return lottoNumberSet;
    }

    public boolean isContain(LottoNumber number) {
        return lottoNumberSet.contains(number);
    }

}
