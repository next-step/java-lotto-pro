package lotto.view;

import lotto.domain.Rank;


import static lotto.view.LottoMessageFormats.*;

public class SimpleLottoView implements LottoView {

    private final OutputTarget output;

    public SimpleLottoView(OutputTarget output) {
        this.output = output;
    }

    @Override
    public void showMessageRequestPurchaseMoney() {
        output.print(MESSAGE_REQUEST_PURCHASE_MONEY);
    }

    @Override
    public void showLottoCount(int count) {
        output.print(String.format(MESSAGE_LOTTO_COUNT,count));
    }

    @Override
    public void showLotto(String lottoString) {
        output.print(lottoString);
        output.print("");
    }

    @Override
    public void showMessageRequestWinningNumbers() {
        output.print(MESSAGE_REQUEST_WINNING_NUMBERS);
    }

    @Override
    public void showMessageStatistics() {
        output.print("");
        output.print(MESSAGE_HEADER_STATISTICS);
    }

    @Override
    public void showStatistics(Rank rank, int count) {
        if(rank.equals(Rank.SECOND)){
            output.print(String.format(MESSAGE_MATCH_INFORMATION_WITH_BONUS,rank.getMatchCount(),rank.getWinningAmountString(),count));
            return;
        }
        output.print(String.format(MESSAGE_MATCH_INFORMATION,rank.getMatchCount(),rank.getWinningAmountString(),count));
    }

    @Override
    public void showYield(double calcYield) {
        output.print(String.format(MESSAGE_YIELD,calcYield) );
    }

    @Override
    public void showMessageRequestBonusNumber() {
        output.print(MESSAGE_REQUEST_BONUS_NUMBER);
    }
}
