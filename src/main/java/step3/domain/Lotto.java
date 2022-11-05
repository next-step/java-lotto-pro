package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final String DELIMITER_REGEX = ",";
    private static final String SPACE_REGEX = "\\s";
    private static final String EMPTY = "";
    private final static String NUMBER_DELIMITER = ", ";
    private final List<LottoNumber> lottoNumbers;
    private int matchCount;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        for (Integer no : lottoNumbers) {
            this.lottoNumbers.add(new LottoNumber(no));
        }
    }

    public Lotto(String numberInput) {
        this.lottoNumbers = convertToIntList(splitByDelimiter(numberInput));
    }

    private void matchCountUp(LottoNumber winningNumber) {
        if (matchNumber(winningNumber)) {
            this.matchCount++;
        }
    }

    public boolean matchNumber(LottoNumber winningNumber) {
        return this.lottoNumbers.contains(winningNumber);
    }

    private int getMatchCount(List<LottoNumber> winningNumbers) {
        this.matchCount = 0;
        winningNumbers.forEach(this::matchCountUp);
        return this.matchCount;
    }

    public int getMatchCount(Lotto winningNumbers) {
        return winningNumbers.getMatchCount(lottoNumbers);
    }

    public String numberToString() {
        return lottoNumbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(NUMBER_DELIMITER));
    }

    public boolean matchBonusNumber(WinningBonusNumber winningBonusNumber) {
        return winningBonusNumber.checkBonusNumber(this);
    }
    
    private static String[] splitByDelimiter(String text) {
        return text.replaceAll(SPACE_REGEX, EMPTY).split(DELIMITER_REGEX);
    }

    private static ArrayList<LottoNumber> convertToIntList(String[] stringArray) {
        ArrayList<LottoNumber> result = new ArrayList<>();
        for (String string : stringArray) {
            result.add(new LottoNumber(string));
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
