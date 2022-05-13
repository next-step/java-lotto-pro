package study.lotto.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private static final String NOTNULL_ERROR = "로또 번호를 입력해주세요.";

    private static final String DELIMITER = ",";

    private List<Integer> lottoNubmers;

    public WinningLottoNumbers(String lottoNumberString) {
        lottoNubmers = validate(lottoNumberString);
    }

    private List<Integer> validate(String lottoNumberString) {
        validateNonNull(lottoNumberString);
        validateNonEmpty(lottoNumberString);
        return Arrays.stream(lottoNumberString.split(DELIMITER)).map(String::trim).map(Integer::new)
                .collect(Collectors.toList());
    }

    private void validateNonNull(String price) {
        if (Objects.isNull(price)) {
            throw new IllegalArgumentException(NOTNULL_ERROR);
        }
    }

    private void validateNonEmpty(String price) {
        if (price.isEmpty()) {
            throw new IllegalArgumentException(NOTNULL_ERROR);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNubmers;
    }
}
