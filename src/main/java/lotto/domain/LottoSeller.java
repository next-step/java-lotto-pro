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

    public LottoTickets lottoTickets(Money receivedMoney, ManualCount manualCount, LottoTickets inputManualTickets) {
        receivedMoney = nullableElseGetReceivedMoney(receivedMoney);
        if (receivedMoney.isLessThenLottoPrice()) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THEN_PRICE_MONEY);
        }
        manualCount = nullableElseGetManualCount(manualCount);
        LottoTickets lottoTickets = nullableElseGetManualTickets(inputManualTickets);

        lottoTickets.addAll(autoLottoTickets(manualCount.autoPurchaseCount(receivedMoney)));
        return lottoTickets;
    }

    private LottoTickets autoLottoTickets(int autoPurchaseCount) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < autoPurchaseCount; i++) {
            lottoTicketList.add(lottoTicket());
        }
        return LottoTickets.from(lottoTicketList);
    }

    private Money nullableElseGetReceivedMoney(Money receivedMoney) {
        return Optional.ofNullable(receivedMoney)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.LESS_THEN_PRICE_MONEY));
    }

    private ManualCount nullableElseGetManualCount(ManualCount manualCount) {
        return Optional.ofNullable(manualCount)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.LESS_THEN_MANUAL_COUNT));
    }

    private LottoTickets nullableElseGetManualTickets(LottoTickets inputManualTickets) {
        return Optional.ofNullable(inputManualTickets)
                .orElseGet(() -> LottoTickets.from(new ArrayList<>()));
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
