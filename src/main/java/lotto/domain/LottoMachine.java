package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class LottoMachine {
    private final static List<Integer> lottoNumberPool = IntStream
            .rangeClosed(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public List<Lotto> getNewMultiLottoList(int lottoTicketCount) {
        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTickets.add(getNewLotto());
        }
        return lottoTickets;
    }

    public Lotto getNewLotto() {
        shuffle(lottoNumberPool);
        return new Lotto(lottoNumberPool.subList(0, 6));
    }
}
