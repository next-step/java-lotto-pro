package study.lotto.domain;

import study.util.NumberUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int MATCH = 1;
    private static final int NOT_MATCH = 0;

    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbersFromStore) {
        this(toSet(numbersFromStore));
    }

    private static Set<LottoNumber> toSet(List<Integer> numbersFromStore) {
        return numbersFromStore.stream()
                .map((num) -> LottoNumber.of(num))
                .collect(Collectors.toSet());
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public LottoStatus drawLots(WinningLotto winningLotto) {
        int result = matchNumbers(winningLotto);
        return LottoStatus.getLottoStatus(result);
    }

    private int matchNumbers(WinningLotto winningLotto) {
        int result = NumberUtil.INIT_ZERO;
        for(LottoNumber lottoNumber : numbers) {
            result += winningLotto.matchNumber(lottoNumber);
        }
        return result;
    }

    public int contains(LottoNumber lottoNumber) {
        if(numbers.contains(lottoNumber)) {
            return MATCH;
        }
        return NOT_MATCH;
    }

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        return Arrays.toString(lottoNumbers.toArray());
    }
}
