package step3_4.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generate(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Rank> getRanks(UniqueNumbers winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> getRank(lotto, winningNumbers, bonusNumber))
                .filter(rank -> !rank.equals(Rank.MISS))
                .collect(Collectors.toList());
    }

    private Rank getRank(Lotto lotto, UniqueNumbers winningNumbers, int bonusNumber) {
        int countOfMatch = lotto.getCountOfMatch(winningNumbers);
        boolean isBonusMatch = lotto.isBonusMatch(bonusNumber);
        return Rank.valueOf(countOfMatch, isBonusMatch);
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
