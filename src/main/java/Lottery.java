import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Lottery {
    public Lottery(LottoNumbers winner) {
        this.winner = winner;
    }

    private final LottoNumbers winner;

    public Map<Prize, Long> get(Lottos lottos) {
        ContainCounts containCounts = new ContainCounts();
        StreamSupport.stream(lottos.spliterator(), false)
                .forEach(lottoNumbers -> containCounts.add(get(lottoNumbers)));
        return aggregateByPrize(containCounts);
    }

    private ContainCount get(LottoNumbers lottoNumbers) {
        return new ContainCount(Math.toIntExact(
                StreamSupport.stream(lottoNumbers.spliterator(), false)
                        .filter(winner::contains)
                        .count()));
    }

    private Map<Prize, Long> aggregateByPrize(ContainCounts containCounts) {
        return StreamSupport.stream(containCounts.spliterator(), false).collect(
                Collectors.groupingBy(ContainCount::find,
                        TreeMap::new,
                        Collectors.counting()));
    }
}
