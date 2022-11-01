package step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final Set<LottoNumber> lottoNumberSet;

    public static final int VALID_SIZE = 6;
    private static final Pattern SPLIT_DELIMITER = Pattern.compile(",");
    private static final Pattern WHITE_SPACE = Pattern.compile("\\s");
    private static final String EMPTY_STRING = "";
    public static final String NOT_MATCHED_NUMBER_SIZE = "[ERROR] 로또 번호는 6개의 숫자가 필요합니다.";
    public static final String EXIST_DUPLICATE_VALUE = "[ERROR] 로또 번호는 중복 숫자가 존재할 수 없습니다.";

    public LottoNumbers(List<LottoNumber> numberList) {
        this.lottoNumberSet = Collections.unmodifiableSet(new HashSet<>(numberList));
        checkDuplicateNumber(numberList);
        checkNumbersSize();
    }

    public LottoNumbers(String receiveWinningNumber) {
        String trimWinningNumber = WHITE_SPACE.matcher(receiveWinningNumber).replaceAll(EMPTY_STRING);
        this.lottoNumberSet = Arrays.stream(SPLIT_DELIMITER.split(trimWinningNumber))
            .map((number) -> new LottoNumber(Integer.parseInt(number)))
            .collect(Collectors.toSet());
        checkNumbersSize();
    }

    private void checkNumbersSize() {
        if (lottoNumberSet.size() != VALID_SIZE) {
            throw new IllegalArgumentException(NOT_MATCHED_NUMBER_SIZE);
        }
    }

    public Set<LottoNumber> getLottoNumberSet() {
        return lottoNumberSet;
    }

    private void checkDuplicateNumber(List<LottoNumber> numberList) {
        if (numberList.size() > this.lottoNumberSet.size()) {
            throw new IllegalArgumentException(EXIST_DUPLICATE_VALUE);
        }
    }

    public int compareTo(final LottoNumbers winningNumbers) {
        return (int) this.lottoNumberSet.stream()
            .filter(winningNumbers.lottoNumberSet::contains)
            .count();
    }

    public boolean containsNumber(final LottoNumber lottoNumber) {
        return this.lottoNumberSet.contains(lottoNumber);
    }
}
