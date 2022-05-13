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

    public Result getResult(Lotto winner, LottoNumber bonusNumber) {
        int count = 0;
        boolean containsBonus = false;
        for (LottoNumber lottoNumber : winner.lottoNumbers) {
            count = plusCountIfContains(count, lottoNumber);
            containsBonus = isContainsBonus(bonusNumber, containsBonus, lottoNumber);
        }
        return Result.from(count, containsBonus);
    }

    private boolean isContainsBonus(LottoNumber bonusNumber, boolean isContainsBonus, LottoNumber lottoNumber) {
        if (lottoNumber.equals(bonusNumber)) {
            isContainsBonus = true;
        }
        return isContainsBonus;
    }

    private int plusCountIfContains(int count, LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            count++;
        }
        return count;
    }
}
