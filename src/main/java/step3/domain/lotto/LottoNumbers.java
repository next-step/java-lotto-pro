package step3.domain.lotto;

import step3.domain.statistics.Match;
import step3.domain.statistics.Rank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.domain.lotto.LottoNumber.END_INCLUSIVE;
import static step3.domain.lotto.LottoNumber.START_INCLUSIVE;
import static step3.domain.statistics.Rank.*;
import static step3.type.ErrorMessageType.LOTTO_NUMBER_WRONG_SIZE;

public class LottoNumbers {

    public static final int DEFAULT_LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = createLottoNumbers();
    }

    public LottoNumbers(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        validateLottoSize(this.lottoNumbers);
    }

    public Rank getRank(WinningLottoNumbers winningLottoNumbers, BonusLottoNumber bonusLottoNumber) {
        int count = getMatchCount(winningLottoNumbers);
        return valueOf(new Match(count, isContains(bonusLottoNumber, count)));
    }

    private boolean isContains(BonusLottoNumber bonusLottoNumber, int matchCount) {
        boolean contains = false;
        if (isSecond(matchCount)) {
            contains = isContains(bonusLottoNumber);
        }
        return contains;
    }

    public boolean isContains(BonusLottoNumber bonusLottoNumber) {
        return this.lottoNumbers.contains(bonusLottoNumber.value());
    }

    private int getMatchCount(WinningLottoNumbers winningLottoNumbers) {
        int count = (int) winningLottoNumbers.value().stream()
                .filter(this.lottoNumbers::contains)
                .count();
        return getCount(count);
    }

    private static int getCount(int count) {
        if (count < FIFTH.getMatch().getCount()) {
            return 0;
        }
        return count;
    }

    private void validateLottoSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != DEFAULT_LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_WRONG_SIZE.getMessage());
        }
    }

    private List<LottoNumber> createLottoNumbers() {
        return pickNumberInRange().stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private List<Integer> pickNumberInRange() {
        List<Integer> integers = IntStream.range(START_INCLUSIVE, END_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(integers);
        return integers.subList(0, DEFAULT_LOTTO_SIZE);
    }

    public List<LottoNumber> value() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
