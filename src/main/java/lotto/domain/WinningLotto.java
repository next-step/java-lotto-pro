package lotto.domain;

import lotto.common.CustomEmptyException;
import lotto.common.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.Constants.NUMBER_SEPARATOR;

/**
 * packageName : lotto.domain
 * fileName : WinningLotto
 * author : haedoang
 * date : 2021/11/07
 * description :
 */
public class WinningLotto {
    public static final int BALL_CNT = 6;

    private final Lotto winningLotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        this.winningLotto = lotto;
        this.bonus = validate(lotto, bonus);
    }

    public WinningLotto(String input, LottoNumber bonus) {
        Lotto winningLotto = new Lotto(input);
        this.winningLotto = winningLotto;
        this.bonus = validate(winningLotto, bonus);
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

