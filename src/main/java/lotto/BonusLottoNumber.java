package lotto;

public class BonusLottoNumber {

    private static final String BONUS_BALL_DUPLICATION = "중복된 번호를 보너스볼로 입력하셨습니다.";
    private final LottoNumber lottoNumber;

    private BonusLottoNumber(int number) {
        this.lottoNumber = LottoNumber.valueOf(number);
    }

    public static BonusLottoNumber valueOf(int number, Lotto lotto) {
        BonusLottoNumber bonusLottoNumber = new BonusLottoNumber(number);
        if (bonusLottoNumber.match(lotto)) {
            throw new IllegalArgumentException(BONUS_BALL_DUPLICATION);
        }
        return bonusLottoNumber;
    }

    public boolean match(Lotto lotto) {
        return lotto.contains(this.lottoNumber);
    }
}
