package lottoauto.wrapper;

import java.util.List;

public class LottoNo {
    int bonusNumber;

    public LottoNo(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean compareBonus(List<Integer> compareLotto) {
        return compareLotto.contains(this.bonusNumber);
    }
}
