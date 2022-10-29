package lotto.domain;

import lotto.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningLottoNumbers {

    private static final String DELIMITER = ",";
    private static final Pattern LOTTO_COMMA_PATTERN = Pattern.compile("^\\d,\\d,\\d,\\d,\\d,\\d$");

    private List<Integer> lottoNumbers;

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public WinningLottoNumbers(String lottoNumbers) {
        validNullOrEmpty(lottoNumbers);
        checkLottoPattern(lottoNumbers);
        this.lottoNumbers = convertToInt(lottoNumbers);
    }

    private void validNullOrEmpty(String lottoNumbers) {
        if (StringUtils.isNullOrEmpty(lottoNumbers)) {
            throw new IllegalArgumentException("지난주 당첨 번호를 입력해주세요.");
        }
    }

    private void checkLottoPattern(String lottoNumbers) {
        Matcher matcher = LOTTO_COMMA_PATTERN.matcher(lottoNumbers);
        if (!matcher.find()) {
            throw new IllegalArgumentException("로또 번호 형식이 올바르지 않습니다.");
        }
    }

    private List<Integer> convertToInt(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.trim().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
