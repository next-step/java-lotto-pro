package lotto.domain;

import static lotto.common.Messages.BONUS_BALL_NOT_NUMBER;

public class BonusBall {

    private final LottoNumber bonusBall;

    public BonusBall(String bonusBall) {
        validateNumber(bonusBall);
        this.bonusBall = new LottoNumber(Integer.parseInt(bonusBall));
    }

    private void validateNumber(String bonusBall) {
        if (!isNumber(bonusBall)) {
            throw new IllegalArgumentException(BONUS_BALL_NOT_NUMBER);
        }
    }

    private boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    @Override
    public String toString() {
        return bonusBall.toString();
    }
}
