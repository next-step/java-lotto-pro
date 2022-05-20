package step3.lotto.domain.lotto;

/**
 * @author : choi-ys
 * @date : 2022/05/18 6:54 오후
 */
public class Winnings {

    public static final String BONUS_NUMBER_ALREADY_EXIST_IN_WINNING_LOTTO_ERROR = "지난주 로또 번호에 포함되지 않는 보너스 번호를 입력하세요.";

    private Lotto winningsLotto;
    private LottoNumber bonusNumber;

    private Winnings(Lotto winningsLotto, LottoNumber bonusNumber) {
        this.winningsLotto = winningsLotto;
        this.bonusNumber = bonusNumber;
    }

    public static Winnings of(Lotto winningsLotto, LottoNumber bonusNumber) {
        validateBonusNumberAlreadyExistInWinningsLotto(winningsLotto, bonusNumber);
        return new Winnings(winningsLotto, bonusNumber);
    }

    private static void validateBonusNumberAlreadyExistInWinningsLotto(Lotto winningsLotto, LottoNumber bonusNumber) {
        if (winningsLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ALREADY_EXIST_IN_WINNING_LOTTO_ERROR);
        }
    }

    public Lotto getWinningsLotto() {
        return winningsLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
