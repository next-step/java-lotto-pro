package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static lotto.domain.WinningBonus.*;

public class WinningMoney {
    private final List<Integer> matchCountPerLotto;

    public WinningMoney(List<Integer> matchCountPerLotto) {
        this.matchCountPerLotto = Collections.unmodifiableList(matchCountPerLotto);
    }

    public int count(WinningBonus bonus) {
        return (int) this.matchCountPerLotto.stream()
                .filter(c -> c.equals(bonus.getMatchCount()))
                .count();
    }

    public double calcYield(Money money) {
        List<WinningBonus> bonusTable = Arrays.stream(values()).collect(Collectors.toList());
        Integer totalBonus = this.matchCountPerLotto.stream()
                .map(c -> calcBonusFromTable(bonusTable, c)).
                reduce(Integer::sum).get();

        return money.divide(totalBonus);
    }

    private Integer calcBonusFromTable(List<WinningBonus> bonuses, Integer c) {
        Optional<WinningBonus> bonus = bonuses.stream().filter(b -> b.same(c)).findFirst();
        return bonus.map(WinningBonus::getBonus).orElse(0);
    }
}
