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

    public LottoTickets autoLottoTickets(Money receivedMoney) {
        if (receivedMoney.isLessThenLottoPrice()) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THEN_PRICE_MONEY);
        }
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < receivedMoney.purchaseCount(); i++) {
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
