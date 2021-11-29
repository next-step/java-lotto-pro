package lotto.domain;

import lotto.consts.LottoNumberConst;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.WrongLottoNumberSizeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        checkNull(numbers);
        checkLottoNumberSize(numbers);
        checkDuplicate(numbers);
        Collections.sort(numbers);
        this.lottoNumbers = toLottoNumber(numbers);
    }

    private void checkNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new NullPointerException();
        }
    }

    private void checkLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoNumberConst.LOTTO_NUMBER_SIZE) {
            throw new WrongLottoNumberSizeException();
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        boolean notDuplicate = numbers.stream().allMatch(new HashSet<>()::add);

        if (!notDuplicate) {
            throw new DuplicateLottoNumberException();
        }
    }

    private List<LottoNumber> toLottoNumber(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
