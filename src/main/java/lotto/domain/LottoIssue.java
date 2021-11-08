package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoIssue {

    private LottoIssue() {
    }

    public static List<LottoNumbers> ofAuto(int purchaseQuantity) {
        return IntStream.range(0, purchaseQuantity)
                .mapToObj(i -> new LottoNumbers(LottoGenerator.generate()))
                .collect(toList());
    }

}
