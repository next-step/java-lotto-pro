package step3.model;

import static java.util.Collections.shuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step3.domain.LottoTicket;

public class LottoGenerator {

    private final int LOTTO_MIN = 1;
    private final int LOTTO_MAX = 45;
    private final int LOTTO_ELEMENTS_SIZE = 6;
    private List<Integer> LOTTO_VALID_ELEMENTS = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX).boxed().collect(Collectors.toList());

    public LottoTicket makeRandomLottoTicket() {
        List<Integer> lottoElements = new ArrayList<>();
        shuffle(LOTTO_VALID_ELEMENTS);
        for (int i = 0; i < LOTTO_ELEMENTS_SIZE; i++) {
            lottoElements.add(LOTTO_VALID_ELEMENTS.get(i));
        }
        return new LottoTicket(lottoElements.stream().map(String::valueOf).collect(Collectors.toList()));
    }

    public LottoTicket makeManualLottoTicket(String manualLottoSource) {
        return new LottoTicket(manualLottoSource);
    }
}
