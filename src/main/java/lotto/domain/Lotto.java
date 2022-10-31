package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

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
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] Lotto는 6개의 숫자입니다.");
        }
    }

    private void duplicateLottoNumbers(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            throw new IllegalArgumentException("[ERROR] Lotto 내 숫자는 중복될 수 없습니다.");
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
