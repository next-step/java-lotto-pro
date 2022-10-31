package lotto;

import lotto.controller.LottoController;
import lotto.dto.LotteriesDto;
import lotto.dto.LottoResultDto;
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
        String winningNumbersUserInput = lottoInputView.readUserInput("지난 주 당첨 번호를 입력해 주세요.");
        LottoResultDto lottoResultDto = lottoController.lottoResult(lotteriesDto, winningNumbersUserInput, buyAmountUserInput);
        lottoResultView.lottoResult(lottoResultDto);
    }
}
