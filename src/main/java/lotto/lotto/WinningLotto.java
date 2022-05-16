package lotto.lotto;

import static java.util.Objects.requireNonNull;

public class WinningLotto {

    private final String maybeLottoNumbers;

    protected WinningLotto(String maybeLottoNumbers) {
        this.maybeLottoNumbers =  requireNonNull(maybeLottoNumbers, "lotto");;
    }

    public static WinningLotto of(String maybeLottoNumbers) {
        return new WinningLotto(maybeLottoNumbers);
    }

    public String getLottoNumbers() {
        return maybeLottoNumbers;
    }
}
