package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Retailer {

    public static Playslips buy(final Price amount) {
        List<Playslip> playslips = new ArrayList<>();
        for (int i = 0; i < amount.calculateNumberOfUnits(); i++) {
            final Numbers numbers = new Numbers(Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)
            ));
            final Playslip playslip = new Playslip(numbers);
            playslips.add(playslip);
        }
        return new Playslips(playslips);
    }
}
