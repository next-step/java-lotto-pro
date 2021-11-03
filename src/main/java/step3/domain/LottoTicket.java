package step3.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private static final int LOTTO_TICKET_SIZE = 6;
    public static final String LOTTO_TICKET_OVER_SIZE_EXCEPTION_MESSAGE = String.format("로또 티켓은 %s 개의 숫자만 가능합니다.",
        LOTTO_TICKET_SIZE);
    private final Set<LottoNumber> lottoTicket = new HashSet<>();

    public LottoTicket(int[] numbers) {
        mapLottoTicket(numbers);
        validTicketSize();
    }

    private void validTicketSize() {
        if (lottoTicket.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException(LOTTO_TICKET_OVER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void mapLottoTicket(int[] numbers) {
        for (int number : numbers) {
            lottoTicket.add(new LottoNumber(number));
        }
    }

    public List<Integer> toLottoNumbers() {
        List<Integer> result = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoTicket) {
            result.add(lottoNumber.toInt());
        }
        return result;
    }
}
