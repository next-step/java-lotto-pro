package lotto.domain;

public class WinLotto extends Lotto {

    private static final String INVALID_VALUE_MESSAGE = "보너스 볼은 숫자여야 합니다.";
    private static final String DUPLICATE_NUMBER_MESSAGE = "보너스 볼은 당첨 번호와 다른 값이어야 합니다.";

    private LottoNumber bonusNumber;

    public WinLotto(String input, String bonusBall) {
        super(input);
        addBonusNumber(bonusBall);
    }

    private void addBonusNumber(String bonusBall) {
        LottoNumber number = new LottoNumber(validateNumberType(bonusBall));
        if (super.isContained(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
        bonusNumber = number;
    }

    private int validateNumberType(String bonusBall) {
        int num = 0;
        try {
            num = Integer.parseInt(bonusBall);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
        return num;
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

}
