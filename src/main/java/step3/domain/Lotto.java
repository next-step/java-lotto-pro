package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import step3.ValidationUtils;

public class Lotto {
    private static final String DELIMITER_REGEX = ",";
    private static final String SPACE_REGEX = "\\s";
    private static final String EMPTY = "";
    private final static String NUMBER_DELIMITER = ", ";
    private final List<Integer> lottoNumbers;
    private int matchCount;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String numberInput) {
        this.lottoNumbers = convertToIntList(splitByDelimiter(numberInput));
    }

    private void matchCountUp(int winningNumber) {
        if (match(winningNumber)) {
            this.matchCount++;
        }
    }

    public int compareMath(List<Integer> winningNumbers) {
        this.matchCount = 0;
        winningNumbers.forEach(this::matchCountUp);
        return this.matchCount;
    }

    public String numberToString() {
        return lottoNumbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(NUMBER_DELIMITER));
    }

    public boolean match(int winningNumber) {
        return this.lottoNumbers.contains(winningNumber);
    }

    public boolean matchBonusNumber(WinningBonusNumber winningBonusNumber) {
        return winningBonusNumber.checkBonusNumber(lottoNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return this.lottoNumbers;
    }

    private static String[] splitByDelimiter(String text) {
        return text.replaceAll(SPACE_REGEX, EMPTY).split(DELIMITER_REGEX);
    }

    private static ArrayList<Integer> convertToIntList(String[] stringArray) {
        ArrayList<Integer> result = new ArrayList<>();
        for (String string : stringArray) {
            result.add(ValidationUtils.parseInt(string));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return matchCount == lotto.matchCount && Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, matchCount);
    }
 
}
