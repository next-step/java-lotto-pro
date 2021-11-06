package lotto.domain.ticket;

import java.util.*;
import java.util.stream.*;

import lotto.domain.number.*;
import lotto.dto.*;

public class TicketGenerator {
    private static final int SUBLIST_START_INDEX = 0;
    private static final int SUBLIST_END_INDEX = 6;

    private static List<LottoNumber> shuffle() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.LOTTO_NUMBER_COLLECTION.values());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static LottoNumbers generate() {
        List<LottoNumber> lottoNumbers = shuffle();

        return LottoNumbers.from(lottoNumbers.subList(SUBLIST_START_INDEX, SUBLIST_END_INDEX)
            .stream()
            .mapToInt(LottoNumber::number)
            .boxed()
            .collect(Collectors.toList()));
    }

    public static List<Ticket> generateTickets(int numberOfTickets) {
        return Stream.generate(TicketGenerator::generate)
            .map(Ticket::from)
            .limit(numberOfTickets)
            .collect(Collectors.toList());
    }

    public static List<LottoNumbersDto> lottoNumbersDtos(List<Ticket> tickets) {
        return tickets.stream()
            .map(e -> LottoNumbersDto.from(e.lottoNumbers()))
            .collect(Collectors.toList());
    }
}
