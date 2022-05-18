package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoConstant.LOTTO_END_NUMBER;
import static lotto.domain.LottoConstant.LOTTO_START_NUMBER;
import static lotto.view.InputView.*;

public class LottoGame {
    private static final List<LottoNo> lottoNumbers = new ArrayList<>();

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumbers.add(new LottoNo(number));
        }
    }

    public LottoGame() {
    }

    public void play() {
        LottoMachine lottoMachine = readMoney();
        OutputView.printMessage(lottoMachine.calculatePurchaseLottos() + "개를 구매했습니다.");

        PurchasedLotto purchasedLotto = purchaseLotto(lottoMachine);
        OutputView.printMyLotto(purchasedLotto);

        Lotto lastWinningLotto = new Lotto(readLastWinningNumbers());
        LottoNo bonusNumber = new LottoNo(readBonusNumber());
        OutputView.printLine();

        LottoResult result = matchLottoNumbers(purchasedLotto, lastWinningLotto, bonusNumber);
        OutputView.showLottoResult(result, lottoMachine);
    }

    public PurchasedLotto purchaseLotto(LottoMachine lottoMachine) {
        long lottoQuantity = lottoMachine.calculatePurchaseLottos();
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottoList.add(generateLotto());
        }
        return new PurchasedLotto(lottoList);
    }

    private Lotto generateLotto() {
        Collections.shuffle(lottoNumbers);
        List<LottoNo> lottoNoList = lottoNumbers.stream()
                .limit(LottoConstant.LOTTO_SIZE)
                .collect(Collectors.toList());
        return new Lotto(lottoNoList);
    }

    public LottoResult matchLottoNumbers(PurchasedLotto purchasedLotto, Lotto lastWinningLotto, LottoNo bonusNumber) {
        List<Ranking> rankings = purchasedLotto.compareLottos(lastWinningLotto, bonusNumber);
        return new LottoResult(rankings);
    }

    private LottoMachine readMoney() {
        String input = InputView.readUserInput(REQUEST_MONEY);
        return new LottoMachine(input);
    }

    private String readLastWinningNumbers() {
        return InputView.readUserInput(REQUEST_LAST_WINNING_NUMBERS);
    }

    private String readBonusNumber() {
        return InputView.readUserInput(REQUEST_BONUS_NUMBER);
    }
}
