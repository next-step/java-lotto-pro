package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoIssue {

    private LottoIssue() {
    }

    public static LottoTicket of(LottoPurchase lottoPurchase, Map<Integer, List<Integer>> inputManualLottoNumbers) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(fromManual(inputManualLottoNumbers));
        lottoNumbers.addAll(fromAuto(lottoPurchase.getAutoPurchaseQuantity()));
        return new LottoTicket(lottoNumbers);
    }

    private static List<LottoNumbers> fromManual(Map<Integer, List<Integer>> inputManualLottoNumbers) {
        return inputManualLottoNumbers.values().stream()
                .map(LottoNumbers::new)
                .collect(toList());
    }

    private static List<LottoNumbers> fromAuto(int purchaseQuantity) {
        return IntStream.range(0, purchaseQuantity)
                .mapToObj(i -> LottoGenerator.generate())
                .collect(toList());
    }

}
