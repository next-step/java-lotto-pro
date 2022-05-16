package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class LottoSeller {
    private static List<Integer> allLottoNumbers = new ArrayList<>(LottoNumber.allLottoNumbers());

    private LottoSeller() {}

    public static LottoSeller create() {
        return new LottoSeller();
    }

    public LottoTickets lottoTickets(Money money, LottoTickets inputManualTickets) {
        LottoTickets lottoTickets = inputManualTickets;
        lottoTickets.addAll(autoLottoTickets(money, inputManualTickets.size()));
        return lottoTickets;
    }

    public LottoTickets autoLottoTickets(Money receivedMoney) {
        return autoLottoTickets(receivedMoney, 0);
    }

    public LottoTickets autoLottoTickets(Money receivedMoney, int manualCount) {
        if (receivedMoney.isLessThenLottoPrice()) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THEN_PRICE_MONEY);
        }
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < receivedMoney.autoPurchaseCount(manualCount); i++) {
            lottoTicketList.add(lottoTicket());
        }
        return LottoTickets.from(lottoTicketList);
    }

    private LottoTicket lottoTicket() {
        return LottoTicket.from(shuffleAndSortNumbers());
    }

    private List<Integer> shuffleAndSortNumbers() {
        Collections.shuffle(allLottoNumbers);
        return allLottoNumbers.stream()
                .limit(Constants.LOTTO_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
