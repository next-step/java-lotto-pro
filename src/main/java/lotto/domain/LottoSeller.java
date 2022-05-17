package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class LottoSeller {
    private static final List<Integer> allLottoNumbers = new ArrayList<>(LottoNumber.allLottoNumbers());

    private LottoSeller() {}

    public static LottoSeller create() {
        return new LottoSeller();
    }

    public LottoTickets lottoTickets(LottoCount lottoCount, LottoTickets inputManualTickets) {
        lottoCount = nullableElseThrowLottoCount(lottoCount);
        inputManualTickets.addAll(autoLottoTickets(lottoCount.autoCount()));
        return inputManualTickets;
    }

    private LottoTickets autoLottoTickets(int autoPurchaseCount) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < autoPurchaseCount; i++) {
            lottoTicketList.add(lottoTicket());
        }
        return LottoTickets.from(lottoTicketList);
    }

    private LottoCount nullableElseThrowLottoCount(LottoCount lottoCount) {
        return Optional.ofNullable(lottoCount)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.LESS_THEN_MANUAL_COUNT));
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
