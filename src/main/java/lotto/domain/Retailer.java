package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Retailer {

    public static Playslips buy(
        final Price amount,
        final List<PickedNumbers> manuallyPickedNumbers
    ) {
        List<Playslip> playslips = new ArrayList<>();
        addManualPlayslips(playslips, manuallyPickedNumbers);
        addAutoPlayslips(playslips, amount.calculateNumberOfUnits() - manuallyPickedNumbers.size());
        return new Playslips(playslips);
    }

    private static void addManualPlayslips(
        final List<Playslip> playslips,
        final List<PickedNumbers> manuallyPickedNumbers
    ) {
        for (PickedNumbers pickedNumbers : manuallyPickedNumbers) {
            playslips.add(new Playslip(pickedNumbers));
        }
    }

    private static void addAutoPlayslips(
        final List<Playslip> playslips,
        final int numberOfAutoPlayslips
    ) {
        for (int i = 0; i < numberOfAutoPlayslips; i++) {
            playslips.add(new Playslip(LottoNumbers.pickRandom()));
        }
    }
}
