package step3.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import step3.message.ErrorMessage;

public class LottoNumbers {
    private static final Pattern PATTERN_OF_SPLIT_DELIMITER = Pattern.compile(",");
    private static final Pattern PATTERN_OF_WHITE_SPACE = Pattern.compile("\\s");
    private static final String EMPTY_STRING = "";
    private static final int NUMBER_MAX_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(final Set<LottoNumber> numbers) {
        this.lottoNumbers = numbers;
        validateNumberSize();
    }

    public LottoNumbers(final String receiveWinningNumber) {
        String trimWinningNumber = PATTERN_OF_WHITE_SPACE.matcher(receiveWinningNumber).replaceAll(EMPTY_STRING);
        this.lottoNumbers = Arrays.stream(PATTERN_OF_SPLIT_DELIMITER.split(trimWinningNumber))
                .map((number) -> new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toSet());
        validateNumberSize();
    }

    private void validateNumberSize() {
        if (this.lottoNumbers.size() < NUMBER_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERR_LOTTO_NUMBER_CAN_NOT_DUPLICATE.message);
        }
    }

    public int compareTo(final LottoNumbers winningNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(winningNumbers.lottoNumbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .sorted()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
