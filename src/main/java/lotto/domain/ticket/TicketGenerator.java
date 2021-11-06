package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.dto.LottoNumbersDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return IntStream.range(0, numberOfTickets)
            .mapToObj(e -> TicketGenerator.generate())
            .map(Ticket::from)
            .collect(Collectors.toList());
    }

    public static List<LottoNumbersDto> lottoNumbersDtos(List<Ticket> tickets) {
        return tickets.stream()
            .map(e -> LottoNumbersDto.from(e.lottoNumbers()))
            .collect(Collectors.toList());
    }
}
