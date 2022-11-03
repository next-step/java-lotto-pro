package lotto.domain;

import lotto.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private LottoNumbers manualLottoNumbers;

    private static final String DELIMITER = ",";
    private static final Pattern LOTTO_COMMA_PATTERN
            = Pattern.compile("^(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+$");

    public ManualLottoGenerator(String lottoNumbers) {
        validNullOrEmpty(lottoNumbers);
        checkLottoPattern(lottoNumbers);
        this.manualLottoNumbers = new LottoNumbers(convertToIntegerList(lottoNumbers));
    }

    @Override
    public LottoNumbers generateLottoNumber() {
        return manualLottoNumbers;
    }

    private void validNullOrEmpty(String lottoNumbers) {
        if (StringUtils.isNullOrEmpty(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호를 입력해주세요.");
        }
    }

    private void checkLottoPattern(String lottoNumbers) {
        Matcher matcher = LOTTO_COMMA_PATTERN.matcher(lottoNumbers);
        if (!matcher.find()) {
            throw new IllegalArgumentException("로또 번호 형식이 올바르지 않습니다.");
        }
    }

    private List<Integer> convertToIntegerList(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.replaceAll("\\s", "").split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
