package lotto;

public class Lotto {

    private final NumberBag numberBag;

    public Lotto(NumberGenerator numberGenerator) {
        this(new LottoNumberBag(numberGenerator));
    }

    public Lotto(LottoNumberBag lottoNumberBag) {
        this.numberBag = lottoNumberBag;
    }

    public WinningResult getResult(WinningLottoBallBag winningLottoBallBag) {
        return WinningResult.getResultByMatchScore(numberBag.matchScore(winningLottoBallBag));
    }

    public NumberBag getNumbers() {
        return numberBag;
    }
}
