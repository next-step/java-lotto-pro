package lotto.domain.factory;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoFactory {
    private static final List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.lottoNumbersCache.values());
    private static final String COMMA_DELIMITER = ",";
    private static final String LOTTO_PATTERN_REGEX = "^[\\d,\\s]*$";
    private static final Pattern lottoNumbersPattern = Pattern.compile(LOTTO_PATTERN_REGEX);
    private static final String SPACE_DELIMITER = "\\s+";
    private static final String EMPTY_STRING = "";
    private static final int LOTTO_COUNT = 6;

    private LottoFactory() {
    }

    public static Lotto create(String lottoNumbers) {
        validateInputString(lottoNumbers);
        return new Lotto(toLottoNumberList(lottoNumbers));
    }

    private static void validateInputString(String lottoNumbers) {
        if (!isLottoPattern(lottoNumbers)) {
            throw new IllegalArgumentException("숫자, 공백 및 문자 , 만 사용 가능합니다.");
        }
    }

    private static boolean isLottoPattern(String lottoNumber) {
        return lottoNumbersPattern.matcher(eraserSpace(lottoNumber))
                .matches();
    }

    private static String[] split(String lottoNumbers) {
        return eraserSpace(lottoNumbers).split(COMMA_DELIMITER);
    }

    private static String eraserSpace(String lottoNumbers) {
        return lottoNumbers.replaceAll(SPACE_DELIMITER, EMPTY_STRING);
    }

    private static List<LottoNumber> toLottoNumberList(String lottoNumbers) {
        return Arrays.stream(split(lottoNumbers))
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static Lotto createAuto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoFactory.lottoNumbers);
        Collections.shuffle(lottoNumbers);
        return new Lotto(
                lottoNumbers.stream().
                limit(LOTTO_COUNT)
                .collect(Collectors.toList()));
    }

}
