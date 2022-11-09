package lotto.ui.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Money;

public class BuyLottoInput {
    private final long amount;
    private final List<List<Integer>> playerPicks;

    public BuyLottoInput(long amount, List<List<Integer>> playerPicks) {
        this.amount = amount;
        this.playerPicks = playerPicks;
    }

    public Money getMoney() {
        return new Money(this.amount);
    }

    public List<LottoNumbers> getPlayerPicks() {
        return playerPicks.stream()
                .map(LottoNumbers::new)
                .collect(Collectors.toList());
    }
}
