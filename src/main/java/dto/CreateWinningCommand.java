package dto;

import domain.Lotto;
import domain.LottoNumber;

import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

public final class CreateWinningCommand {

    public final Set<Integer> previous;

    public CreateWinningCommand(Set<Integer> previous) {
        this.previous = previous;
    }

    public Lotto toWinning() {
        return previous.stream()
                .map(LottoNumber::of)
                .collect(collectingAndThen(toSet(), Lotto::new));
    }
}
