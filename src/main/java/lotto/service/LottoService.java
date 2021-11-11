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
    public static void play() {
        int boughtMoney = InputView.inputBoughtMoney();
        validateBoughtMoney(boughtMoney);
        int lottoCount = LottoServiceCalculator.getLottoCount(boughtMoney);
        ResultView.printLottoCount(lottoCount);
        List<Lotto> lottoList = createLottoList(lottoCount);
        ResultView.printLottoNumbers(lottoList);
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(StringUtils.separate(InputView.inputWinningNumber()),
                                                                                    new BonusNumber(InputView.inputBonusNumber()));
        Map<LottoPrize, Integer> lottoResultMap = createLottoResult(lottoList, winningLottoNumbers);
        ResultView.printWinningStatistics(lottoResultMap);
        ResultView.printProfitRate(LottoServiceCalculator.calculateProfitRate(lottoResultMap, boughtMoney));
    }

    private static void validateBoughtMoney(int boughtMoney) {
        if (boughtMoney <= 0) {
            throw new IllegalArgumentException("구매급액은 0 이상의 값을 입력해주세요.");
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

    private static List<Lotto> createLottoList(int lottoCount) {
        List<Lotto> lottoList = new LinkedList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(new LottoNumbers(ShuffledLottoNumbers.createShuffledLottoNumbers())));
        }
        return lottoList;
    }
}
