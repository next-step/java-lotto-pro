package lotto;

public class WinningLotto {

    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        if (lotto.isContains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 중복될 수 없습니다.");
        }
        this.lotto = lotto;
        this.bonusNumber = new Number(bonusNumber);
    }

}
