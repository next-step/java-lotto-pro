package lotto.controller;

import lotto.util.GameRule;
import lotto.view.GameMessage;

public class LottoMoney {

    public int parseIntBuyPrice(String buyPrice){

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
    public int getLottoPaperCount(int buyPrice) {

        return buyPrice / GameRule.LOTTO_PAPER_PRICE;
    }
}
