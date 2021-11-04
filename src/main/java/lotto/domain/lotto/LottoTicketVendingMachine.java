package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.lotto.LottoNumber.MAX_LOTTO_BOUND;
import static lotto.domain.lotto.LottoNumber.MIN_LOTTO_BOUND;
import static lotto.domain.lotto.LottoTicket.LOTTO_NUMBER_SIZE;

public class LottoTicketVendingMachine {

    private static final List<LottoNumber> LOTTO_NUMBER_BOX = generate();

    private static List<LottoNumber> generate() {
        return IntStream.rangeClosed(MIN_LOTTO_BOUND, MAX_LOTTO_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTickets issueTickets(int autoTicketAmount) {
        List<LottoTicket> lottoTickets = autoIssueTickets(autoTicketAmount);
        return LottoTickets.from(lottoTickets);
    }

    private List<LottoTicket> autoIssueTickets(int autoTicketAmount) {
        return IntStream.range(0, autoTicketAmount)
                .mapToObj(i -> autoLottoNumbers())
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    private Set<LottoNumber> autoLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_BOX);
        return LOTTO_NUMBER_BOX.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .collect(Collectors.toSet());
    }
}
