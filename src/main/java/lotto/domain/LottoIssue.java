package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoIssue {

    private LottoIssue() {
    }

    public static LottoTicket ofAuto(int purchaseQuantity) {
        List<LottoNumbers> lottoNumbers = IntStream.range(0, purchaseQuantity)
                .mapToObj(i -> LottoGenerator.generate())
                .collect(toList());
        return new LottoTicket(lottoNumbers);
    }

}
