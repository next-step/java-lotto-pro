package lotto.view;

public class InputView {

    private InputView() {

    }
    public static void printBuyPriceInput() {
        System.out.println(GameMessage.BUY_PRICE_INPUT);
    }

    public static void printWinningNumberInput() {
        System.out.println(GameMessage.WINNING_NUMBER_INPUT);
    }

    public static void printBonusNumberInput() {
        System.out.println(GameMessage.BONUS_NUMBER_INPUT);
    }

    public static void printManualLottoBuyCountInput() {
        System.out.println(GameMessage.MANUAL_LOTTO_BUY_COUNT_INPUT);
    }

    public static void printManualLottoNumberInput() {
        System.out.println(GameMessage.MANUAL_LOTTO_NUMBER_INPUT);
    }

}
