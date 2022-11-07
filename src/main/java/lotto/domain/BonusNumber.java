package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BonusNumber {

    private static final Map<LottoNumber,BonusNumber> bonusNumbers;

    private LottoNumber lottoNumber;

    static {
        bonusNumbers = LottoNumber.lottoNumberMinToMax().stream()
                .collect(Collectors.toMap(Function.identity(), BonusNumber::new));
    }

    private BonusNumber(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static BonusNumber of(int lottoNumber) {
        return of(LottoNumber.of(lottoNumber));
    }

    public static BonusNumber of(LottoNumber lottoNumber) {
        return bonusNumbers.get(lottoNumber);
    }

    public boolean isLottoMatch(Lotto lotto) {
        return lotto.isMatch(lottoNumber);
    }

    public boolean isMatch(List<Integer> intList) {
        return intList.stream().map(LottoNumber::of).anyMatch(lottoNumber -> lottoNumber.equals(this.lottoNumber));
    }
}
