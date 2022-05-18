package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRoleConst;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<String> lottoNumberWords) {
        List<LottoNumber> lottoNumbers = convertLottoNumbers(lottoNumberWords);
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private List<LottoNumber> convertLottoNumbers(List<String> lottoNumberWords) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String winningNumberWord : lottoNumberWords) {
            lottoNumbers.add(new LottoNumber(winningNumberWord));
        }
        return lottoNumbers;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        validateNumbersSize(lottoNumbers);
        validateDuplication(lottoNumbers);
    }

    private void validateNumbersSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoRoleConst.LOTTO_NUMBER_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NON_SIX_NUMBERS);
        }
    }

    private void validateDuplication(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> deleteDuplicationNumber = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != deleteDuplicationNumber.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION);
        }
    }

    public boolean contains(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int[] numberToIntArray() {
        return lottoNumbers.stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();
    }

    public int matchCount(LottoNumbers winningNumbers) {
        return Math.toIntExact(lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }
}
