package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketFactory {
    private static final String COMMA = ", ";

    private LottoTicketFactory() {
    }

    public static LottoTicket createLottoTicket() {
        List<Integer> allLottoNumbers = createAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);
        List<Integer> lottoNumbers = allLottoNumbers.subList(
            LottoNumbersSize.LOTTO_NUMBERS_ZERO_SIZE.getSize(), LottoNumbersSize.LOTTO_NUMBERS_SIZE.getSize());
        Collections.sort(lottoNumbers);
        return new LottoTicket(lottoNumbers);
    }

    private static List<Integer> createAllLottoNumbers() {
        return IntStream.range(LottoNumberRange.LOTTO_NUMBER_MIN_RANGE.getRange(),
                LottoNumberRange.LOTTO_NUMBER_MAX_RANGE.getRange())
            .boxed()
            .collect(Collectors.toList());
    }

    public static LottoTicket createManualLottoTicket(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        String[] inputNumbersBySplit = inputNumbers.split(COMMA);
        for (String number : inputNumbersBySplit) {
            numbers.add(Integer.parseInt(number));
        }
        return new LottoTicket(numbers);
    }
}
