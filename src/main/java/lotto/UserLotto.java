package lotto;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private final List<LottoNumber> lottoNumbers;

    public UserLotto(int count) {
        lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(new LottoNumber(LottoGeneratorUtil.generate()));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
