package lotto.model.lotto.ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 자동 생성한 6 개의 로또 번호 한 줄을 저장하고 관리하는 객체이다.
 */
public class LottoTicket {
    private static final int COUNT_OF_NUMBERS_IN_SINGLE_LOTTO_TICKET = 6;
    private final List<Integer> numbers;

    public LottoTicket() {
        this.numbers = new ArrayList<>(COUNT_OF_NUMBERS_IN_SINGLE_LOTTO_TICKET);
        List<Integer> candidates = new ArrayList<>(Arrays.asList(1, 2, 3));
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
        for (int i = 0; i < COUNT_OF_NUMBERS_IN_SINGLE_LOTTO_TICKET; ++i) {
            numbers.add(lottoNumberGenerator.generate());
        }
    }
}
