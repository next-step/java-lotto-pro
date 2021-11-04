package lotto.domain;

import lotto.module.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final List<LottoNumbers> ticket;

    public LottoTicket(final List<LottoNumbers> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket generate(final int boughtCount, final NumberGeneratorStrategy strategy) {
        return new LottoTicket(
                IntStream.range(0, boughtCount)
                        .mapToObj(i -> strategy.createLotto())
                        .collect(Collectors.toList())
        );
    }

    public List<LottoNumbers> getTicket() {
        return new ArrayList<>(ticket);
    }

}
