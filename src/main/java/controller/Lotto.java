package controller;

import model.*;
import view.InputReader;
import view.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(InputReader.readPurchaseAmount());

        LottoLotteryTickets lottoLotteryTickets = createLottoLotteryTickets(lottoPurchaseAmount);

        WinningLottoNumbers winningLottoNumbers = createWinningLottoNumbers();

        calcalateLottoResult(lottoLotteryTickets, winningLottoNumbers, lottoPurchaseAmount);
    }

    private LottoLotteryTickets createLottoLotteryTickets(LottoPurchaseAmount lottoPurchaseAmount) {
        String lottoCountToPurchaseManualLotto = InputReader.readPurchaseLottoNumber();
        lottoPurchaseAmount.validCheckBuyableLotto(lottoCountToPurchaseManualLotto);

        LottoLotteryTickets manualLottoLotteryTickets = createManualLottoLotteryTickets(lottoCountToPurchaseManualLotto);
        LottoLotteryTickets lottoLotteryTickets = LottoLotteryTickets.createLottoLotteryTickets(manualLottoLotteryTickets, lottoPurchaseAmount.getBuyableAutoLottoNumbers(lottoCountToPurchaseManualLotto));

        OutputWriter.printLottoQuantity(  lottoCountToPurchaseManualLotto, lottoPurchaseAmount.getBuyableAutoLottoNumbers(lottoCountToPurchaseManualLotto) );
        OutputWriter.print(lottoLotteryTickets.toString());

        return lottoLotteryTickets;
    }

    private WinningLottoNumbers createWinningLottoNumbers() {
        LottoNumbers lastWeekWinningLottoNumbers = new LottoNumbers(InputReader.readLastWeekWinningNumber());
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(lastWeekWinningLottoNumbers);
        winningLottoNumbers.addBonusBall(new LottoNumber(InputReader.readBonusBall()));

        return winningLottoNumbers;
    }

    private void calcalateLottoResult(LottoLotteryTickets lottoLotteryTickets, WinningLottoNumbers winningLottoNumbers, LottoPurchaseAmount lottoPurchaseAmount) {
        Result result = lottoLotteryTickets.matchResult(winningLottoNumbers);
        OutputWriter.printResults(result, lottoPurchaseAmount);
    }

    private LottoLotteryTickets createManualLottoLotteryTickets(String lottoCountToPurchase) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();

        OutputWriter.printInquireManualLottoNumbersDirection();
        for (int i = 0; i < Integer.parseInt(lottoCountToPurchase); i++) {
            lottoNumbers.add(new LottoNumbers(InputReader.readManualLottoNumbers()));
        }

        return new LottoLotteryTickets(lottoNumbers);
    }
}
