package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import step3.domain.constance.LottoConstant;

public class LottoTicket {

    private final Set<LottoNumber> lottoTicket = new HashSet<>();

    public LottoTicket(int[] numbers) {
        mapLottoTicket(numbers);
        validTicketSize();
    }

    public List<Integer> toLottoNumbers() {
        List<Integer> result = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoTicket) {
            result.add(lottoNumber.toInt());
        }
        Collections.sort(result);
        return Collections.unmodifiableList(result);
    }

    public int containCounting(LottoTicket winningLottoTicket) {
        List<Integer> lottoNumbers = toLottoNumbers();
        int count = 0;
        for (Integer winNumber : winningLottoTicket.toLottoNumbers()) {
            if (lottoNumbers.contains(winNumber)) {
                count++;
            }
        }
        return count;
    }

    private void validTicketSize() {
        if (lottoTicket.size() != LottoConstant.LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException(LottoConstant.LOTTO_TICKET_OVER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void mapLottoTicket(int[] numbers) {
        for (int number : numbers) {
            lottoTicket.add(new LottoNumber(number));
        }
    }
}
