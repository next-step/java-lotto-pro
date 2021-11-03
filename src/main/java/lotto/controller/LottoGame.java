package lotto.controller;

import lotto.model.LottoNumber;
import lotto.model.LottoPaper;
import lotto.model.LottoPaperList;
import lotto.model.LottoResult;
import lotto.util.GameRule;
import lotto.view.GameMessage;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {

    private static final LottoNumberRandomGenerator lottoNumberRandomGenerator = new LottoNumberRandomGenerator();

    public static int parseIntBuyPrice(String buyPrice){

        try {
            int parseBuyPrice = Integer.parseInt(buyPrice);
            if(parseBuyPrice < GameRule.LOTTO_PAPER_PRICE){
                throw new IllegalArgumentException(ResultView.invalidInputMsg(GameMessage.ERROR_BUY_PRICE_INPUT));
            }
            return parseBuyPrice;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ResultView.invalidInputMsg(GameMessage.ERROR_BUY_PRICE_INPUT));
        }

    }
    public static int getLottoPaperCount(int buyPrice) {

        return buyPrice / GameRule.LOTTO_PAPER_PRICE;
    }

    public static LottoPaperList getLottoPaperList(long lottoPaperCount) {
        List<LottoPaper> lottoPaperList = new ArrayList<>();
        for (int i = 0; i < lottoPaperCount; i++) {
            lottoPaperList.add(getLottoPaper());
        }
        return new LottoPaperList(lottoPaperList);
    }

    private static LottoPaper getLottoPaper() {
        return new LottoPaper(lottoNumberRandomGenerator.getLottoNumberList());
    }

    public static LottoPaper getWinningNumber(String input) {

        List<LottoNumber> lottoNumberList = new ArrayList<>();
        Arrays.asList(input.split(GameRule.LOTTO_NUMBER_DELIMITER))
                .forEach(number -> lottoNumberList.add(new LottoNumber(parseWinningNumber(number))) );

        if (lottoNumberList.size() != GameRule.LOTTO_END_INDEX) {
            throw new IllegalArgumentException(ResultView.invalidInputMsg(GameMessage.ERROR_LOTTO_NUMBER_INPUT));
        }
        return new LottoPaper(lottoNumberList);
    }

    private static int parseWinningNumber(String number) {

        try {
            int parseNumber = Integer.parseInt(number);
            lottoNumberRangeCheck(parseNumber);
            return parseNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ResultView.invalidInputMsg(GameMessage.ERROR_WINNING_NUMBER_INPUT));
        }
    }

    private static void lottoNumberRangeCheck(int number) {
        if (number < GameRule.LOTTO_START_NUMBER || number > GameRule.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ResultView.invalidInputMsg(GameMessage.ERROR_WINNING_NUMBER_INPUT));
        }
    }

    public static LottoResult getLottoResult(LottoPaperList lottoPaperList, LottoPaper winningLottoPaper) {
        LottoResult lottoResult = new LottoResult();
        lottoPaperList.getLottoPaperList().forEach(lottoPaper -> matchLottoPaper(lottoPaper, winningLottoPaper, lottoResult));
        return  lottoResult;
    }

    public static void matchLottoPaper(LottoPaper lottoPaper, LottoPaper winningLottoPaper, LottoResult lottoResult) {
        lottoPaper.getLottoNumber().forEach(lottoNumber -> checkContainsLottoNumber(lottoNumber, winningLottoPaper, lottoResult));
        lottoResult.addMatchCountMap(lottoResult.getMatchCount());
        lottoResult.clearMatchCount();
    }

    public static void checkContainsLottoNumber(LottoNumber lottoNumber, LottoPaper winningLottoPaper, LottoResult lottoResult) {

        if(winningLottoPaper.getLottoNumber().contains(lottoNumber)){
            lottoResult.addMatchCount();
        }
    }
}
