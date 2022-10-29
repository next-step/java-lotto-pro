package controller;

import model.LottoLotteryTickets;
import model.LottoNumberGenerator;
import model.LottoPurchaseAmount;
import view.InputReader;
import view.OutputWriter;

public class Lotto {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(InputReader.inquirePurchaseAmount());
        OutputWriter.answerLottoQuantity(lottoPurchaseAmount.getQuantityPerAmountLotto());

        LottoLotteryTickets lottoLotteryTickets = new LottoLotteryTickets(lottoPurchaseAmount.getQuantityPerAmountLotto(), new LottoNumberGenerator());
        OutputWriter.answerLottoLotteryTickets(lottoLotteryTickets.toString());
    }
}
