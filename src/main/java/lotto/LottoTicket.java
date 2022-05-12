package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(LottoPurchaseQuantity lottoPurchaseQuantity) {
        lottoNumbers = Stream.generate(AutomaticLottoNumber::new)
                .limit(lottoPurchaseQuantity.getQuantity())
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
