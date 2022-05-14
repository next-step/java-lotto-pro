import java.util.stream.StreamSupport;

public class Lottery {
    public Lottery(LottoNumbers winner) {
        this.winner = winner;
    }

    private final LottoNumbers winner;

    public ContainCount get(LottoNumbers lottoNumbers) {
        return new ContainCount(Math.toIntExact(
                StreamSupport.stream(lottoNumbers.spliterator(), false)
                        .filter(winner::contains)
                        .count()
        ));
    }

    public ContainCounts get(Lottos lottos) {
        ContainCounts containCounts = new ContainCounts();
        StreamSupport.stream(lottos.spliterator(), false)
                .forEach(lottoNumbers -> containCounts.add(get(lottoNumbers)));
        return containCounts;
    }

}
