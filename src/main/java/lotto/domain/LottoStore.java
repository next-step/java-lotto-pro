package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoStore {
    private final LottoNumberGenerateStrategy lottoNumberGenerateStrategy;

    public LottoStore(final LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        this.lottoNumberGenerateStrategy = lottoNumberGenerateStrategy;
    }

    public LottoTickets buy(int purchaseCount) {
        List<LottoTicket> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoList.add(ticketPrinting(lottoNumberGenerateStrategy));
        }
        return new LottoTickets(lottoList);
    }

    public LottoTickets buy(List<String> manualLottoNumbers) {
        if (!manualLottoNumbers.isEmpty()) {
            return manualLottoNumbers.stream()
                    .map(LottoTicket::new)
                    .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::new));
        }
        return new LottoTickets(Collections.emptyList());
    }

    public static LottoTicket ticketPrinting(LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        Set<Integer> generatedNumber = lottoNumberGenerateStrategy.generate();
        return new LottoTicket(generatedNumber.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet()));
    }
}
