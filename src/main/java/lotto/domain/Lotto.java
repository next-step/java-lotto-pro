package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final String ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 6개의 숫자를 입력해주세요.";
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_SIZE);

        this.lottoNumbers = new ArrayList<>();
        for (Integer lottoNumber : lottoNumbers)
            this.lottoNumbers.add(new LottoNumber(lottoNumber));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
