package study.lotto.domain;

import study.util.NumberUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbersFromStore) {
        this.numbers = toSet(numbersFromStore);
    }

    private Set<LottoNumber> toSet(List<Integer> numbersFromStore) {
        return numbersFromStore.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public LottoStatus drawLots(WinningLotto winningLotto) {
        return LottoStatus.getLottoStatus(
                matchNumbers(winningLotto),
                winningLotto.isMatchBonusBall(this)
        );
    }

    private int matchNumbers(WinningLotto winningLotto) {
        int result = NumberUtil.INIT_ZERO;

        for(LottoNumber lottoNumber : numbers) {
            result += winningLotto.matchNumber(lottoNumber);
        }

        return result;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);

        return Arrays.toString(lottoNumbers.toArray());
    }
}
