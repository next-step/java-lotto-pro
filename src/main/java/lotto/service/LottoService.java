package lotto.service;

import java.util.ArrayList;
import lotto.domain.LottoCount;
import lotto.domain.LottoGame;
import lotto.domain.LottoLine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;
import lotto.exception.LottoCountException;
import lotto.util.LottoStringGenerator;
import lotto.view.InputView;

public class LottoService {

    private static final int LOOP_START_VALUE = 0;
    private static final int DEFAULT_VALUE = 0;
    private static final String ERROR_LOTTO_COUNT_LIMIT = "[ERROR] 수동으로 구매할 수 있는 로또 수를 초과하였습니다.";

    public LottoGame buyAutoLotto(LottoPayment lottoPayment, LottoCount manualLottoCount){
        return LottoGame.issueLotto(getLottoLineCount(lottoPayment), manualLottoCount.toLottoCountDTO().getLottoCount());
    }

    public LottoCount getManualLottoCount(LottoPayment lottoPayment, int manualCount){
        return new LottoCount(manualCount);
    }

    public void validateManualLottoCount(LottoPayment lottoPayment, LottoCount lottoCount){
        int autoCount = lottoPayment.getLottoLineCount() - lottoCount.toLottoCountDTO().getLottoCount();
        if(autoCount < DEFAULT_VALUE){
            throw new LottoCountException(ERROR_LOTTO_COUNT_LIMIT);
        }
    }

    public LottoGame getManualLottoGame(LottoCount manualLottoCount){
        LottoGame manualLottoGame = new LottoGame(new ArrayList<>());
        for (int i = LOOP_START_VALUE; i < manualLottoCount.toLottoCountDTO().getLottoCount(); i++) {
            manualLottoGame.addLottoLine(inputManualLottoLine());
        }
        return manualLottoGame;
    }

    public LottoLine inputManualLottoLine(){
        return LottoStringGenerator.toLottoLine(InputView.inputManualLottoLine());
    }

    private int getLottoLineCount(LottoPayment lottoPayment){
        return lottoPayment.getLottoLineCount();
    }

    public LottoGame joinLottoGame(LottoGame source, LottoGame destination){
        return LottoGame.joinLottoGame(source, destination);
    }

    public LottoLine inputLastWeekWinningLottoLine(){
        return LottoStringGenerator.toLottoLine(InputView.inputLastWeekWinningLottoLine());
    }

    public LottoResult getLottoResult(LottoGame lottoGame, LottoLine winLottoLine, LottoNumber bonusNumber){
        return lottoGame.getLottoResult(winLottoLine, bonusNumber);
    }
}
