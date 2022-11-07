package lotto;

import lotto.controller.LottoController;
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

    private static final int ALL_AUTO_DIRECT_BUY_NUMBER = 0;

    public static void main(String[] args) {
        BuyAmountDto buyAmountDto = lottoController
                .getBuyAmount(lottoInputView.readUserInput("구입금액을 입력해 주세요."));

        BuyCountLottoDto buyCountLottoDto = lottoController.
                getBuyCountLotto(lottoInputView.readUserInput("수동으로 구매할 로또 수를 입력해 주세요."),
                        buyAmountDto);

        if(buyCountLottoDto.getDirectBuyCount() == ALL_AUTO_DIRECT_BUY_NUMBER) {
            getLotteriesAndResult(new LotteriesDto(Arrays.asList(new ArrayList<>()), new Lotteries(new ArrayList<>())),
                    buyCountLottoDto, buyAmountDto);
            return;
        }

        getLotteriesAndResult(getDirectLotteries(buyCountLottoDto.getDirectBuyCount()),buyCountLottoDto,buyAmountDto);
    }

    private static LotteriesDto getDirectLotteries(int buyLottoCount) {
        LotteriesDto directLotteriesDto = lottoController.
                initDirectLotteries(lottoInputView.readUserInput("수동으로 구매할 번호를 입력해 주세요."));

        for (int i = 0; i < buyLottoCount - 1; i++) {
            lottoController.mergeLotteries(directLotteriesDto, lottoInputView.readUserInput(""));
        }
        return directLotteriesDto;
    }

    private static void getLotteriesAndResult(LotteriesDto directLotteriesDto,
                                             BuyCountLottoDto buyCountLottoDto, BuyAmountDto buyAmountDto) {
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
