package lotto.domain;

import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int PRICE = 1_000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static final String LOTTO_NUMBER_ERROR = "중복된 로또 번호가 존재합니다.";
    public static final String LOTTO_NUMBER_COUNT_ERROR = String.format(
            "로또 번호는 1장에 %d개만 가능합니다.", LOTTO_NUMBER_COUNT);

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(LottoNumber... lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            addLottoNumber(lottoNumber);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public void addLottoNumber(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            throw new LottoException(LOTTO_NUMBER_ERROR);
        }
        if (lottoNumbers.size() == 6) {
            throw new LottoException(LOTTO_NUMBER_COUNT_ERROR);
        }
        lottoNumbers.add(lottoNumber);
    }

    public int match(Lotto lotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            count += matchCount(lottoNumber);
        }
        return count;
    }

    private int matchCount(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return getLottoNumbers().toString();
    }
}
