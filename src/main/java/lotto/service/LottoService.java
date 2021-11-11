package lotto.service;

import lotto.domain.*;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final int MINIMUM_AUTO_LOTTO_COUNT = 0;

    public static void play() {
        int boughtMoney = BoughtMoneyService.getBoughtMoney(InputView.inputBoughtMoney());
        int manualLottoCount = InputView.inputManualLottoCount();;
        int autoLottoCount = LottoServiceCalculator.getLottoCount(boughtMoney) - manualLottoCount;
        validateManualLottoCount(autoLottoCount);
        List<Lotto> lotties = ManualLottoService.createManualLotties(manualLottoCount, InputView.inputManualLottoNumbers(manualLottoCount));
        lotties.addAll(createAutoLotties(autoLottoCount));
        ResultView.printLottoCount(manualLottoCount, autoLottoCount);
        ResultView.printLottoNumbers(lotties);
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(StringUtils.separate(InputView.inputWinningNumber()),
                                                                                    new BonusNumber(InputView.inputBonusNumber()));
        Map<LottoPrize, Integer> lottoResultMap = createLottoResult(lotties, winningLottoNumbers);
        ResultView.printWinningStatistics(lottoResultMap);
        ResultView.printProfitRate(LottoServiceCalculator.calculateProfitRate(lottoResultMap, boughtMoney));
    }

    private static void validateManualLottoCount(int autoLottoCount) {
        if (autoLottoCount < MINIMUM_AUTO_LOTTO_COUNT) {
            throw new IllegalArgumentException("수동 로또 개수는 총 구매한 로또 개수를 넘으면 안됩니다.");
        }
    }

    private static Map<LottoPrize, Integer> createLottoResult(List<Lotto> lottoList, WinningLottoNumbers winningLottoNumbers) {
        Map<LottoPrize, Integer> lottoResultMap = new HashMap<>();
        for (Lotto lotto : lottoList) {
            LottoPrize lottoPrize = lotto.compareWinningNumbers(winningLottoNumbers);
            int lottoWinningCount = lottoResultMap.getOrDefault(lottoPrize, 0);
            lottoResultMap.put(lottoPrize, ++lottoWinningCount);
        }
        return lottoResultMap;
    }

    private static List<Lotto> createAutoLotties(int autoLottoCount) {
        List<Lotto> lotties = new LinkedList<>();
        for (int i = 0; i < autoLottoCount; i++) {
            lotties.add(new Lotto(new LottoNumbers(ShuffledLottoNumbers.createShuffledLottoNumbers())));
        }
        return lotties;
    }
}
