package lotto.domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.message.ErrorMessages;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        validateNonDuplicatedNumbers(lottoNumbers);
        validateSixNumbers(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto fromBy(List<Integer> lottoNumbers) {
        return from(toLottoNumbers(lottoNumbers));
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private static void validateNonDuplicatedNumbers(List<LottoNumber> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(String.format(ErrorMessages.DUPLICATED_LOTTO_NUMBERS, lottoNumbers));
        }
    }

    private static void validateSixNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(ErrorMessages.INVALID_LOTTO_NUMBERS_COUNT, lottoNumbers));
        }
    }

    public int matches(List<LottoNumber> winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
