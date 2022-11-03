package lotto.domain;

import lotto.constants.Rank;
import lotto.util.InputValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int COLLECT_ADD_NUMBER = 1;
    private static final int NOT_COLLECT_ADD_NUMBER = 0;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<Integer> lottoNumbers){
        InputValidator.validateLottoNumberCount(lottoNumbers.size());
        InputValidator.validateDuplicateLottoNumber(lottoNumbers);
        return new Lotto(lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    public Rank countCollectNumber(Lotto winningNumbers, LottoNumber bonusBall) {
        int collectCount = 0;
        for (LottoNumber winningNumber : winningNumbers.lottoNumbers) {
            collectCount += containNumbers(winningNumber);
        }
        return Rank.valueOf(collectCount, containNumbers(bonusBall) == COLLECT_ADD_NUMBER);
    }

    public int containNumbers(LottoNumber winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return COLLECT_ADD_NUMBER;
        }
        return NOT_COLLECT_ADD_NUMBER;
    }

    @Override
    public String toString() {
        lottoNumbers.sort(LottoNumber::compareTo);
        return lottoNumbers.toString();
    }
}