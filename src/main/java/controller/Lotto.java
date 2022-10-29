package controller;

import model.LottoPurchaseAmount;
import view.InputReader;
import view.OutputWriter;

public class Lotto {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(InputReader.inquirePurchaseAmount());
        OutputWriter.answerLottoQuantity(lottoPurchaseAmount.getQuantityPerAmountLotto());
    }
}
