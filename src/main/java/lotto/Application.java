package lotto;

import lotto.controller.LottoController;
import lotto.dto.*;
import lotto.view.LotteriesView;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class Application {

    private static final LottoInputView lottoInputView = new LottoInputView();
    private static final LotteriesView lotteriesView = new LotteriesView();
    private static final LottoResultView lottoResultView = new LottoResultView();
    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        String buyAmountUserInput = lottoInputView.readUserInput("구입금액을 입력해 주세요.");
        LotteriesDto lotteriesDto = lottoController.buyLotto(buyAmountUserInput);
        lotteriesView.lotteriesResult(lotteriesDto);
        WinningNumbersDto winningNumbersDto = lottoController
                .readWinningNumbers(lottoInputView.readUserInput("지난 주 당첨 번호를 입력해 주세요."));
        winningNumbersDto = lottoController
                .readBonusNumber(winningNumbersDto, lottoInputView.readUserInput("보너스 볼을 입력해 주세요."));
        LottoResultDto lottoResultDto = lottoController
                .lottoResult(new LottoResultRequestDto(lotteriesDto, winningNumbersDto, buyAmountUserInput));
        lottoResultView.lottoResult(lottoResultDto);
    }
}
