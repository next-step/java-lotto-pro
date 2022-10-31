package controller;

import model.*;
import view.InputReader;
import view.OutputWriter;

public class Lotto {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(InputReader.readPurchaseAmount());
        OutputWriter.printLottoQuantity(lottoPurchaseAmount.getQuantityPerAmountLotto());

        LottoLotteryTickets lottoLotteryTickets = new LottoLotteryTickets(lottoPurchaseAmount.getQuantityPerAmountLotto(), new LottoNumberGenerator());
        OutputWriter.print(lottoLotteryTickets.toString());
        LottoNumbers winningNumbers = new LottoNumbers(InputReader.readLastWeekWinningNumber());

        winningNumbers.addBonusBall(new LottoNumber(InputReader.readBonusBall()));
        Result result = lottoLotteryTickets.matchResult(winningNumbers);

        OutputWriter.printResults(result, lottoPurchaseAmount);
    }
}
