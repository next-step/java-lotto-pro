package controller;

import model.*;
import view.InputReader;
import view.OutputWriter;

public class Lotto {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(InputReader.inquirePurchaseAmount());
        OutputWriter.answerLottoQuantity(lottoPurchaseAmount.getQuantityPerAmountLotto());

        LottoLotteryTickets lottoLotteryTickets = new LottoLotteryTickets(lottoPurchaseAmount.getQuantityPerAmountLotto(), new LottoNumberGenerator());
        OutputWriter.answer(lottoLotteryTickets.toString());

        WinningNumbers winningNumbers = new WinningNumbers(InputReader.inquireLastWeekWinningNumber());
        Result result = lottoLotteryTickets.match(winningNumbers);

        OutputWriter.answer(result.toString());
    }
}
