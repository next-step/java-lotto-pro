package step3.model;

import step3.constant.ErrorMessageConstant;

class Game {
    private static final int LOTTO_ONE_GAME_MONEY = 1000;
    private final int lottoBuyCount;

    public Game(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstant.EMPTY_TEXT);
        }

        this.lottoBuyCount = getLottoBuyCount(convertNumber(money));
    }

    private int getLottoBuyCount(int money) {
        return money / LOTTO_ONE_GAME_MONEY;
    }

    private int convertNumber(String text) {
        int result;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(step2.ErrorMessageConstant.NOT_NUMBER);
        }
        if (result < 0) {
            throw new NumberFormatException(step2.ErrorMessageConstant.NEGATIVE_NUMBER);
        }
        return result;
    }

    public int getLottoBuyCount() {
        return lottoBuyCount;
    }
}
