package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Retailer {

    public static Playslips buy(final Price amount) {
        List<Playslip> playslips = new ArrayList<>();
        for (int i = 0; i < amount.calculateNumberOfUnits(); i++) {
            playslips.add(new Playslip(LottoNumbers.pickRandom()));
        }
        return new Playslips(playslips);
    }
}
