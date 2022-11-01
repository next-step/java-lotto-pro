package lotto.domain;

import lotto.constant.LottoMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        for (int number : numbers) {
            LottoNumber lottoNumber = new LottoNumber(number);
            duplicateLottoNumbers(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        Collections.sort(lottoNumbers);
    }

    private void validateLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_SIZE);
        }
    }

    private void duplicateLottoNumbers(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_DUPLICATE_NUMBER);
        }
    }

    public List<Integer> lottoNumbers() {
        return lottoNumberIntList(lottoNumbers);
    }

    private List<Integer> lottoNumberIntList(List<LottoNumber> lottoNumbers) {
        List<Integer> list = new ArrayList<>();
        for(LottoNumber lottoNumber : lottoNumbers) {
            list.add(lottoNumber.getLottoNumber());
        }
        return list;
    }

    public int countMatchNumber(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                .filter(winLotto.lottoNumbers::contains)
                .count();
    }
}
