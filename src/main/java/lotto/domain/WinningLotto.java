package lotto.domain;

public class WinningLotto extends Lotto {

    private final LottoNumber bonusBall;

    public WinningLotto(String numbers, String bonusBall) {
        super(getLottoNumbers(numbers));
        this.bonusBall = LottoNumber.of(bonusBall);
        validateDuplicate();
    }

    private void validateDuplicate() {
        if (super.match(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼은 로또 번호와 중복될 수 없습니다.");
        }
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.match(bonusBall);
    }

}
