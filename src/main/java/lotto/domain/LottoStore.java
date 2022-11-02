package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoStore {
    private final GenerateStrategy generateStrategy;

    public LottoStore(final GenerateStrategy generateStrategy) {
        this.generateStrategy = generateStrategy;
    }

    public LottoTickets buy(int purchaseAmount) {
        List<LottoTicket> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottoList.add(ticketPrinting(generateStrategy));
        }
        return new LottoTickets(lottoList);
    }

    public static LottoTicket ticketPrinting(GenerateStrategy generateStrategy) {
        Set<Integer> generatedNumber = generateStrategy.generate();
        return new LottoTicket(generatedNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }
}
