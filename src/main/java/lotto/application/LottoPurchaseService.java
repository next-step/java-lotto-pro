package lotto.application;

import lotto.domain.Playslips;
import lotto.domain.Price;
import lotto.domain.Retailer;

public class LottoPurchaseService {

    public static PlayslipsResponse purchase(final String purchaseAmount) {
        final Playslips playslips = Retailer.buy(new Price(purchaseAmount));
        return new PlayslipsResponse(playslips);
    }
}
