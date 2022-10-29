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
        this.output.print(MESSAGE_REQUEST_PURCHASE_MONEY);
    }

    @Override
    public void showLottoCount(int count) {
        this.output.print(String.format(MESSAGE_LOTTO_COUNT,count));
    }

    @Override
    public void showLotto(String lottoString) {
        output.print(lottoString);
        output.print("");
    }

    @Override
    public void showMessageRequestWinningNumbers() {
        this.output.print(MESSAGE_REQUEST_WINNING_NUMBERS);
    }

    @Override
    public void showMessageStatistics() {
        this.output.print("");
        this.output.print(MESSAGE_HEADER_STATISTICS);
    }

    @Override
    public void showStatistics(Rank bonus, int count) {
        this.output.print(String.format(MESSAGE_MATCH_INFORMATION,bonus.getMatchCount(),bonus.getWinningAmountString(),count));
    }

    @Override
    public void showYield(double calcYield) {
        this.output.print(String.format(MESSAGE_YIELD,calcYield) );
    }
}
