package step3.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final Set<LottoNumber> lottoNumberSet;

    public static final int VALID_SIZE = 6;

    public static final String NOT_MATCHED_NUMBER_SIZE = "[ERROR] 로또 번호는 6개의 숫자가 필요합니다.";
    public static final String EXIST_DUPLICATE_VALUE = "[ERROR] 로또 번호는 중복 숫자가 존재할 수 없습니다.";

    public LottoNumbers(List<LottoNumber> numberList) {
        this.lottoNumberSet = Collections.unmodifiableSet(new HashSet<>(numberList));
        checkDuplicateNumber(numberList);
        checkNumbersSize();
    }

    private void checkNumbersSize() {
        if (!(lottoNumberSet.size() == VALID_SIZE)) {
            throw new IllegalArgumentException(NOT_MATCHED_NUMBER_SIZE);
        }
    }

    private void checkDuplicateNumber(List<LottoNumber> numberList) {
        if (numberList.size() > this.lottoNumberSet.size()) {
            throw new IllegalArgumentException(EXIST_DUPLICATE_VALUE);
        }
    }
}
