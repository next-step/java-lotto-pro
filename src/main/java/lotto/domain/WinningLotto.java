package lotto.domain;

/**
 * packageName : lotto.domain
 * fileName : WinningLotto
 * author : haedoang
 * date : 2021/11/07
 * description :
 */
public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonus;

    private WinningLotto(Lotto lotto, LottoNumber bonus) {
        this.winningLotto = lotto;
        this.bonus = validate(lotto, bonus);
    }

    private WinningLotto(String input, LottoNumber bonus) {
        Lotto winningLotto = new Lotto(input);
        this.winningLotto = winningLotto;
        this.bonus = validate(winningLotto, bonus);
    }

    public static WinningLotto valueOf(Lotto lotto, LottoNumber bonus) {
        return new WinningLotto(lotto, bonus);
    }

    public static WinningLotto valueOf(String input, LottoNumber bonus) {
        return new WinningLotto(input, bonus);
    }

    private LottoNumber validate(Lotto lotto, LottoNumber bonus) {
        if (isDuplicate(lotto, bonus)) throw new IllegalArgumentException("중복된 볼은 올 수 없습니다.");
        return bonus;
    }

    private boolean isDuplicate(Lotto lotto, LottoNumber bonus) {
        return lotto.has(bonus);
    }

    public boolean has(LottoNumber number) {
        return this.winningLotto.has(number);
    }

    public boolean isBonus(LottoNumber lottoNumber) {
        return bonus.equals(lottoNumber);
    }
}

