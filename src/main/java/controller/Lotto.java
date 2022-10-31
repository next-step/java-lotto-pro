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

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(new LottoNumbers(InputReader.readLastWeekWinningNumber()));
        winningLottoNumbers.addBonusBall(new LottoNumber(InputReader.readBonusBall()));

        Result result = lottoLotteryTickets.matchResult(winningLottoNumbers);
        OutputWriter.printResults(result, lottoPurchaseAmount);
    }
}
