package lotto.model;

import java.util.List;

public class WinLotto {
    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinLotto(List<Integer> numbers, int bonus) {
        validateBonus(numbers, bonus);
        this.bonus = new LottoNumber(bonus);
        this.lotto = new Lotto(numbers);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonus() {
        return bonus;
    }

    private void validateBonus(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스번호가 지난당첨번호안에 중복이 될수 없습니다.");
        }
    }

    public boolean containNumber(LottoNumber number) {
        return lotto.getLottoNumber().contains(number);
    }
}
