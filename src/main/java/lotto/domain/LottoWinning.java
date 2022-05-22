package lotto.domain;

public class LottoWinning {
    public static final String ERROR_BONUS_NUMBER = "[ERROR] 중복없이 6개의 숫자와 보너스볼 숫자를 입력해주세요.";

    private final Lotto answerLotto;
    private final LottoNumber bonusLottoNumber;

    public LottoWinning(Lotto answerLotto, LottoNumber bonusLottoNumber) {
        if (answerLotto.getLottoNumbers().contains(bonusLottoNumber))
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER);

        this.answerLotto = answerLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Lotto getAnswerLotto() {
        return answerLotto;
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
