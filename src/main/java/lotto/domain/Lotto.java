package lotto.domain;

import lotto.util.InputValidator;
import lotto.util.LottoNumberGenerator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int COLLECT_ADD_NUMBER = 1;
    private static final int NOT_COLLECT_ADD_NUMBER = 0;

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = LottoNumberGenerator.generateLottoNumbers().lottoNumbers;
    }

    public Lotto(List<Integer> lottoNumbers) {
        InputValidator.validateDuplicateLottoNumber(lottoNumbers);
        this.lottoNumbers = mapToLotto(lottoNumbers);
    }

    private List<LottoNumber> mapToLotto(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int countCollectNumber(Lotto winningNumbers) {
        int collectCount = 0;
        for (LottoNumber winningNumber : winningNumbers.lottoNumbers) {
            collectCount += containNumbers(winningNumber);
        }
        return collectCount;
    }

    private int containNumbers(LottoNumber winningNumber) {
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
