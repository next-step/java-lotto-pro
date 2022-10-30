package controller;

import model.*;
import view.InputReader;
import view.OutputWriter;

public class Lotto {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(InputReader.inquirePurchaseAmount());
        OutputWriter.printLottoQuantity(lottoPurchaseAmount.getQuantityPerAmountLotto());

        LottoLotteryTickets lottoLotteryTickets = new LottoLotteryTickets(lottoPurchaseAmount.getQuantityPerAmountLotto(), new LottoNumberGenerator());
        OutputWriter.print(lottoLotteryTickets.toString());

        LottoNumbers winningNumbers = new LottoNumbers(InputReader.inquireLastWeekWinningNumber());
        Result result = lottoLotteryTickets.matchResult(winningNumbers);

        OutputWriter.print(result.toString());
    }
}
