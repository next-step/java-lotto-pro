package study.lotto.domain.draw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumbers;
import study.lotto.domain.lottomachine.LottoGenerator;

public class LottoDraw {
    private final LottoNumbers winningNumber;

    public LottoDraw(LottoNumbers lottoNumbers) {
        winningNumber = lottoNumbers;
    }

    public LottoDraw(LottoGenerator lottoGenerator) {
        winningNumber = lottoGenerator.generate();
    }

    public Division match(Lotto lotto) {
        return Division.valueOfMatchCount(lotto.match(winningNumber));
    }

    public Map<Division, Long> match(List<Lotto> lottoList) {
        return lottoResult(lottoList).entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    }

    private Map<Division, Long> lottoResult(List<Lotto> lottoList) {
        Map<Division, Long> winResult = findWinnings(lottoList);
        Map<Division, Long> allResult = createDefaultResult();
        winResult.forEach((division, count) -> allResult.merge(division, count, (count1, count2) -> count1 + count2));
        return allResult;
    }

    private Map<Division, Long> createDefaultResult() {
        return Arrays.stream(Division.values())
                .collect(Collectors.toMap(division -> division, division -> 0L));
    }

    private Map<Division, Long> findWinnings(List<Lotto> lottoList) {
        return lottoList.stream().map(this::match)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(division -> division, Collectors.counting()));
    }

    @Override
    public String toString() {
        return "LottoDraw{" +
                "winningNumber=" + winningNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoDraw lottoDraw = (LottoDraw) o;
        return Objects.equals(winningNumber, lottoDraw.winningNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber);
    }
}
