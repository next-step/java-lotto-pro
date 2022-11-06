package step3.model;

import java.util.List;

public class LottoBonus extends Lotto {

    private int bonus;

    public LottoBonus(List<Integer> lotto, int bonus) {
        super(lotto);
        this.bonus = bonus;

        validateUniqueBonus(lotto, bonus);
    }

    private void validateUniqueBonus(List<Integer> lotto, int bonus) {
        lotto.stream()
                .forEach(lottoNumber -> validateSameBall(bonus, lottoNumber));
    }

    private void validateSameBall(int bonus, int lottoNumber) {
        if (lottoNumber == bonus) {
            throw new RuntimeException("번호가 동일한게 존재합니다.");
        }
    }

    @Override
    public boolean isMatchedBonus(Lotto lotto) {
        return lotto.contains(this.bonus);
    }
}
