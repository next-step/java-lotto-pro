package lotto.domain;

import lotto.enums.LottoRank;

public class WinningLotto {

    private static final String BONUS_BALL_CONTAINS_ERROR = "[ERROR] 보너스 볼이 당첨 번호와 중복 될 수 없습니다.";

    private LottoNumbers answer;
    private LottoNumber bonusNumber;

    private WinningLotto(LottoNumbers answer, LottoNumber bonusNumber) {
        this.answer = answer;
        validateBonusBall(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(LottoNumbers answer, LottoNumber bonusNumber) {
        return new WinningLotto(answer, bonusNumber);
    }

    private void validateBonusBall(LottoNumber bonusNumber) {
        if (answer.checkContains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_BALL_CONTAINS_ERROR);
        }
    }

    public LottoRank match(LottoNumbers lottoNumbers) {
        return LottoRank.valueOf(answer.hitCounts(lottoNumbers), lottoNumbers.checkContains(bonusNumber));
    }
}
