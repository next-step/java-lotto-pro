import java.util.stream.StreamSupport;

public class Lottery {
    private final LottoNumbers ranksLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public Lottery(LottoNumbers ranksLottoNumbers, LottoNumber bonusLottoNumber) {
        this.ranksLottoNumbers = ranksLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Ranks aggregate(Lotto lotto) {
        Ranks ranks = new Ranks();

        for (LottoNumbers lottoNumbers : lotto) {
            ranks.add(compare(lottoNumbers));
        }

        return ranks;
    }

    private Rank compare(LottoNumbers lottoNumbers) {
        return Rank.valueOf(
                Math.toIntExact(StreamSupport
                        .stream(lottoNumbers.spliterator(), false)
                        .filter(this.ranksLottoNumbers::contains)
                        .count()
                ),
                lottoNumbers.contains(this.bonusLottoNumber)
        );
    }
}
