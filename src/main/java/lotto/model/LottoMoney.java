package lotto.model;

import lotto.util.GameRule;
import lotto.view.GameMessage;

public class LottoMoney {

    private final int money;
    private int manualLottoPaperCount;

    public LottoMoney(String money) {
        this.money = parseIntBuyPrice(money);
    }

    private int parseIntBuyPrice(String buyPrice){
        try {
            int parseBuyPrice = Integer.parseInt(buyPrice);
            if(parseBuyPrice < GameRule.LOTTO_PAPER_PRICE){
                throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERROR_BUY_PRICE_INPUT));
            }
            return parseBuyPrice;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERROR_BUY_PRICE_INPUT));
        }
    }

    public int getLottoPaperCount() {
        return this.money / GameRule.LOTTO_PAPER_PRICE - manualLottoPaperCount;
    }

    public int buyManualLottoPaper(String count) {

        try {
            int parsedCount = Integer.parseInt(count);
            if (parsedCount < 0) {
                throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERROR_NUMBER_INPUT));
            }
            if (parsedCount > getLottoPaperCount()) {
                throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERROR_MANUAL_LOTTO_BUY_COUNT_INPUT));
            }
            manualLottoPaperCount = parsedCount;
            return parsedCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERROR_NUMBER_INPUT));
        }

    }

    public int getManualLottoPaperCount() {
        return manualLottoPaperCount;
    }

    public boolean isMoneySame(int money) {
        return this.money == money;
    }
}
