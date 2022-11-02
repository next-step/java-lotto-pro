package step3.domain;

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

    public List<Rank> getRanks(UniqueNumbers winningNumbers, Number bonusNumber) {
        validateDuplicated(winningNumbers, bonusNumber);
        return lottos.stream()
                .map(lotto -> getRank(lotto, winningNumbers, bonusNumber))
                .filter(rank -> !rank.equals(Rank.MISS))
                .collect(Collectors.toList());
    }

    private Rank getRank(Lotto lotto, UniqueNumbers winningNumbers, Number bonusNumber) {
        int countOfMatch = lotto.getCountOfMatch(winningNumbers);
        boolean isBonusMatch = lotto.isBonusMatch(bonusNumber);
        return Rank.valueOf(countOfMatch, isBonusMatch);
    }

    private static void validateDuplicated(UniqueNumbers winningNumbers, Number bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Duplicate Unique numbers and Bonus number.");
        }
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
