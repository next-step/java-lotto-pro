package lotto;

import lotto.controller.LottoController;
import lotto.domain.BuyCountLotto;
import lotto.domain.Lotteries;
import lotto.dto.*;
import lotto.view.LotteriesView;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    private static final LottoInputView lottoInputView = new LottoInputView();
    private static final LotteriesView lotteriesView = new LotteriesView();
    private static final LottoResultView lottoResultView = new LottoResultView();
    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        BuyAmountDto buyAmountDto = lottoController
                .getBuyAmount(lottoInputView.readUserInput("구입금액을 입력해 주세요."));

        BuyCountLottoDto buyCountLottoDto = lottoController.
                getBuyCountLotto(lottoInputView.readUserInput("수동으로 구매할 로또 수를 입력해 주세요."),
                        buyAmountDto);

        if(buyCountLottoDto.getDirectBuyCount() == 0) {
            getLotteriesAndResult(buyCountLottoDto,
                    new LotteriesDto(Arrays.asList(new ArrayList<>()), new Lotteries(new ArrayList<>())), buyAmountDto);
            return;
        }

        LotteriesDto directLotteriesDto = lottoController.
                getDirectLotteries(lottoInputView.readUserInput("수동으로 구매할 번호를 입력해 주세요."));
        getLotteriesAndResult(buyCountLottoDto,directLotteriesDto,buyAmountDto);

    }

    public static void getLotteriesAndResult(BuyCountLottoDto buyCountLottoDto,
                                             LotteriesDto directLotteriesDto, BuyAmountDto buyAmountDto) {
        LotteriesDto lotteriesDto = lottoController.buyLotto(buyCountLottoDto, directLotteriesDto);

        lotteriesView.lotteriesResult(lotteriesDto);

        WinningNumbersDto winningNumbersDto = lottoController
                .getWinningNumbers(lottoInputView.readUserInput("지난 주 당첨 번호를 입력해 주세요."));

        winningNumbersDto = lottoController
                .getBonusNumber(winningNumbersDto, lottoInputView.readUserInput("보너스 볼을 입력해 주세요."));

        LottoResultDto lottoResultDto = lottoController
                .lottoResult(new LottoResultRequestDto(lotteriesDto, winningNumbersDto, buyAmountDto));

        lottoResultView.lottoResult(lottoResultDto);
    }
}
