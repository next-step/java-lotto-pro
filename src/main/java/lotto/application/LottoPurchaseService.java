package lotto.application;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.PickedNumbers;
import lotto.domain.Playslips;
import lotto.domain.Price;
import lotto.domain.Retailer;

public class LottoPurchaseService {

    public static PlayslipsResponse purchase(
        final String purchaseAmount,
        List<String> manuallyPickedNumbers
    ) {
        final Playslips playslips = Retailer.buy(
            new Price(purchaseAmount),
            manuallyPickedNumbers.stream()
                .map(PickedNumbers::of)
                .collect(Collectors.toList())
        );
        return new PlayslipsResponse(playslips, manuallyPickedNumbers.size());
    }
}
