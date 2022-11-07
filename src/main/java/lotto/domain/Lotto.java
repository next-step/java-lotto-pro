package lotto.domain;

import lotto.constants.Rank;
import lotto.util.InputValidator;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.InputValidator.ERROR_MESSAGE_DUPLICATED_NUMBER;

public class Lotto {

    public static final int COLLECT_ADD_NUMBER = 1;
    private static final int NOT_COLLECT_ADD_NUMBER = 0;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        InputValidator.validateLottoNumberCount(lottoNumbers.size());
        validateDuplicateLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));
    }

    private void validateDuplicateLottoNumber(List<LottoNumber> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            try {
                throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATED_NUMBER);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
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