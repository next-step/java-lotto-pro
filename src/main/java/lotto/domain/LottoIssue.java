package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoIssue {

    private LottoIssue() {
    }

    public static List<Lotto> ofAuto(int purchaseQuantity) {
        return IntStream.range(0, purchaseQuantity)
                .mapToObj(i -> new Lotto(LottoGenerator.generate()))
                .collect(toList());
    }
}
