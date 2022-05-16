import java.util.stream.StreamSupport;

public class Lottery {
    private final LottoNumbers lottoNumbers;
    private final BonusLottoNumber bonusLottoNumber;

    public Lottery(LottoNumbers lottoNumbers, BonusLottoNumber bonusLottoNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Ranks get(Lotto lotto) {
        Ranks ranks = new Ranks();

        for (LottoNumbers lottoNumbers : lotto) {
            ranks.add(get(lottoNumbers));
        }

        return ranks;
    }

    private Rank get(LottoNumbers lottoNumbers) {
        return Rank.valueOf(
                Math.toIntExact(StreamSupport
                        .stream(lottoNumbers.spliterator(), false)
                        .filter(this.lottoNumbers::contains)
                        .count()
                ),
                lottoNumbers.contains(this.bonusLottoNumber)
        );
    }
}
