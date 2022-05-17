package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus;

    private WinningLotto(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("당첨번호에 보너스 번호가 포함될 수 없습니다.");
        }
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinningLotto of(String winningLottoNumber, int bonusNumber) {
        return new WinningLotto(new Lotto(LottoNumber.parse(winningLottoNumber)), new LottoNumber(bonusNumber));
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}
