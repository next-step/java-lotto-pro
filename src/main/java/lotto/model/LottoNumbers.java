package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoPurchaseQuantity lottoPurchaseQuantity) {
        lottoNumbers = Stream.generate(AutomaticLottoNumber::new)
                .limit(lottoPurchaseQuantity.getQuantity())
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoRanks getLottoRanks(LottoNumber winningLottoNumber) {
        return LottoRanks.of(
                lottoNumbers.stream()
                        .map(lottoNumber -> lottoNumber.getLottoRank(winningLottoNumber))
                        .collect(Collectors.toList())
        );
    }
}
