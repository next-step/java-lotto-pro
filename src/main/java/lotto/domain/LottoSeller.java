package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {
    private final Money receivedMoney;

    private LottoSeller(Money receivedMoney) {
        this.receivedMoney = receivedMoney;
    }

    public static LottoSeller from(Money receivedMoney) {
        if (receivedMoney.isLessThenLottoPrice()) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THEN_PRICE_MONEY);
        }
        return new LottoSeller(receivedMoney);
    }

    public static LottoSeller from(int receivedMoney) {
        return from(Money.from(receivedMoney));
    }

    public LottoTickets autoLottoTickets() {
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
        List<Integer> allLottoNumbers = shuffleLottoNumbers();
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < Constants.LOTTO_SIZE; i++) {
            lottoNumbers.add(allLottoNumbers.get(i));
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private List<Integer> shuffleLottoNumbers() {
        List<Integer> allLottoNumbers =  IntStream
                .rangeClosed(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(allLottoNumbers);
        return allLottoNumbers;
    }
}
