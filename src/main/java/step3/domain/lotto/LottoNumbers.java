package step3.domain.lotto;

import step3.domain.generator.LottoFactory;
import step3.domain.statistics.Match;
import step3.domain.statistics.Rank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static step3.domain.statistics.Rank.isSecond;
import static step3.domain.statistics.Rank.valueOf;
import static step3.type.ErrorMessageType.LOTTO_NUMBER_WRONG_SIZE;

public class LottoNumbers {

    public static final int DEFAULT_LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        validateLottoSize(this.lottoNumbers);
    }

    public LottoNumbers(LottoFactory factory) {
        this.lottoNumbers = factory.create();
    }

    public Rank getRank(WinningLottoNumbers winningLottoNumbers, BonusLottoNumber bonusLottoNumber) {
        int count = getMatchCount(winningLottoNumbers);
        return valueOf(new Match(count, isContains(bonusLottoNumber, count)));
    }

    public boolean isContains(BonusLottoNumber bonusLottoNumber) {
        return this.lottoNumbers.contains(bonusLottoNumber.value());
    }

    public List<LottoNumber> value() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private boolean isContains(BonusLottoNumber bonusLottoNumber, int matchCount) {
        boolean contains = false;
        if (isSecond(matchCount)) {
            contains = isContains(bonusLottoNumber);
        }
        return contains;
    }

    private int getMatchCount(WinningLottoNumbers winningLottoNumbers) {
        return (int) winningLottoNumbers.value().stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    private void validateLottoSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != DEFAULT_LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_WRONG_SIZE.getMessage());
        }
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
