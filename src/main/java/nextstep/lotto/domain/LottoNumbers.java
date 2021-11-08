package nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private static final Integer LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
        while (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            LottoNumber lottoNumber = new LottoNumber();
            lottoNumbers.add(lottoNumber);
        }
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }


}
