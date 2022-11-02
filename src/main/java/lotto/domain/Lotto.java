package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.LOTTO_NUMBER_COUNT;
import static lotto.ui.ConsoleMessage.ERROR_VALID_LOTTO_NUMBERS;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        validate(uniqueNumbers);
        this.lottoNumbers = uniqueNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private void validate(final Set<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_VALID_LOTTO_NUMBERS.getMessage());
        }
    }

    public Rank compareTo(WinningLotto winningLotto) {

        Set<LottoNumber> copy = new HashSet<>(lottoNumbers);

        boolean isMatchBonusBall = matchBonusBallCount(winningLotto, copy);
        int matchBallCount = matchBallCount(winningLotto, copy);

        return Rank.valueOf(new MatchCount(matchBallCount, isMatchBonusBall));
    }

    private int matchBallCount(final WinningLotto winningLotto, final Set<LottoNumber> lottoNumbers) {
        lottoNumbers.retainAll(winningLotto.getLottoNumbers());
        return lottoNumbers.size();
    }

    private boolean matchBonusBallCount(final WinningLotto winningLotto, final Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(winningLotto.getBonusBall());
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        ArrayList<LottoNumber> copy = new ArrayList<>(this.lottoNumbers);
        Collections.sort(copy);
        return copy.toString();
    }
}
