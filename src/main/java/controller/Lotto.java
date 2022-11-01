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

        LottoNumbers lastWeekWinningLottoNumbers = new LottoNumbers(InputReader.readLastWeekWinningNumber());
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(lastWeekWinningLottoNumbers);
        winningLottoNumbers.addBonusBall(new LottoNumber(InputReader.readBonusBall()));

        Result result = lottoLotteryTickets.matchResult(winningLottoNumbers);
        OutputWriter.printResults(result, lottoPurchaseAmount);
    }
}
