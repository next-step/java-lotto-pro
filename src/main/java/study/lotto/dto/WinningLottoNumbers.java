package study.lotto.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private static final String NOTNULL_ERROR = "로또 번호를 입력해주세요.";

    private static final String DELIMITER = ",";
    private static final Pattern LOTTO_PATTERN = Pattern.compile(
            "^(\\d|\\s)*,(\\d|\\s)*,(\\d|\\s)*,(\\d|\\s)*,(\\d|\\s)*,(\\d|\\s)*$");

    private List<Integer> lottoNubmers;

    public WinningLottoNumbers(String lottoNumberString) {
        lottoNubmers = validate(lottoNumberString);
    }

    private List<Integer> validate(String lottoNumberString) {
        validateNonNull(lottoNumberString);
        validateNonEmpty(lottoNumberString);
        validateLottoPattern(lottoNumberString);
        return Arrays.stream(lottoNumberString.split(DELIMITER)).map(String::trim).map(Integer::new)
                .collect(Collectors.toList());
    }

    private void validateNonNull(String lottoNumberString) {
        if (Objects.isNull(lottoNumberString)) {
            throw new IllegalArgumentException(NOTNULL_ERROR);
        }
    }

    private void validateNonEmpty(String lottoNumberString) {
        if (lottoNumberString.isEmpty()) {
            throw new IllegalArgumentException(NOTNULL_ERROR);
        }
    }

    private void validateLottoPattern(String lottoNumberString) {
        if (!LOTTO_PATTERN.matcher(lottoNumberString).find()) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자가 쉼표로 연결되어 있는 형태여야 합니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNubmers;
    }
}
