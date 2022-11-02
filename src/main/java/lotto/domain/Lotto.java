package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        if(numbers.size() != LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException("로또 번호의 갯수는 6개 여야 합니다");
        }
    }
    @Override
    public String toString() {
        String joinedLottoNumbers = numbers.stream()
                .sorted()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(","));

        return String.format("[%s]", joinedLottoNumbers);
    }

    public Rank getRankBy(WinningLotto winningLotto) {
        long matchCount = numbers.stream()
                .filter(winningLotto::hasSameNumber)
                .count();

        boolean hasBonusNumber = numbers.stream()
                .anyMatch(winningLotto::hasBonus);
        return Rank.findRank(matchCount, hasBonusNumber);
    }

    public boolean hasSameNumber(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }
}
