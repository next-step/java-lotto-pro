package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final String ERROR_MESSAGE_MUST_BE_SIX_NUMBER = "로또는 서로 다른 6개의 숫자여야 합니다.";
    private static final int SIZE = 6;

    private final Set<LottoNumber> lottoNumbers = new HashSet<>();

    public Lotto() {
        this(LottoNumbers.pick());
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers.addAll(lottoNumbers);
        if (this.lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MUST_BE_SIX_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream().map(LottoNumber::getNumber).sorted().collect(Collectors.toList());
    }

    public Result getResult(Lotto winner) {
        int count = 0;
        for (LottoNumber lottoNumber : winner.lottoNumbers) {
            count = plusCountIfContains(count, lottoNumber);
        }
        return Result.from(count);
    }

    private int plusCountIfContains(int count, LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            count++;
        }
        return count;
    }
}
