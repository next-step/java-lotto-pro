package lotto.model;

import java.util.List;

public class WinLotto extends Lotto {
    private final LottoNumber bonus;

    public WinLotto(List<Integer> numbers, int bonus) {
        super(numbers);
        validateBonus(numbers, bonus);
        this.bonus = new LottoNumber(bonus);
    }

    public LottoNumber getBonus() {
        return bonus;
    }

    private void validateBonus(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스번호가 지난당첨번호안에 중복이 될수 없습니다.");
        }
    }
}
