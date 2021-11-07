package lotto.model;

public class WinningLotto {

    private final LottoPaper winningLottoPaper;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(LottoPaper winningLottoPaper, LottoNumber bonusLottoNumber) {
        this.winningLottoPaper = winningLottoPaper;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoPaper getWinningLottoPaper() {
        return winningLottoPaper;
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
