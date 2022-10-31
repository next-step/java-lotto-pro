package step3.domain;

import step3.enums.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public Rank match(WinningLotto winningLotto) {
        List<Integer> copy = lottoNumbers.getLottoNumbers().stream()
                .mapToInt(LottoNumber::getLottoNumber)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> winningNumbers = winningLotto.getWinningNumber().getLottoNumbers().stream()
                .mapToInt(LottoNumber::getLottoNumber)
                .boxed()
                .collect(Collectors.toList());
        copy.retainAll(winningNumbers);
        return Rank.rank(copy.size(), lottoNumbers.hasBonusNumber(winningLotto.getBonusNumber()));
    }

}
