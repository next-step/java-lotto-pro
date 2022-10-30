package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개가 필요 합니다.");
        }
    }

    public Rank compareTo(WinningLotto winningLotto) {

        Set<LottoNumber> copy = new HashSet<>(lottoNumbers);

        int matchBonusBallCount = matchBonusBallCount(winningLotto, copy);
        int matchBallCount = matchBallCount(winningLotto, copy);

        return Rank.valueOf(new MatchCount(matchBallCount, matchBonusBallCount));
    }

    private int matchBallCount(final WinningLotto winningLotto, final Set<LottoNumber> lottoNumbers) {
        lottoNumbers.retainAll(winningLotto.getLottoNumbers());
        return lottoNumbers.size();
    }

    private int matchBonusBallCount(final WinningLotto winningLotto, final Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.contains(winningLotto.getBonusBall())) {
            return 1;
        }
        return 0;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
