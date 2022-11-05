package study.lotto;

import study.lotto.service.LottoService;
import study.lotto.service.OrderService;
import study.lotto.view.LottoInput;
import study.lotto.view.LottoOutput;

public class LottoGames {

    private final LottoInput input = new LottoInput();
    private final LottoOutput output = new LottoOutput();

    private final OrderService orderService = new OrderService();
    private final LottoService lottoService = new LottoService(orderService);

    public void start() {
        order();
        output.printLottos(lottoService.getPrintedLottos());

        inputWinningNumbers();
        inputBonusBall();

        lottoService.drawLots();
        output.printWinStats(lottoService.getPrintDataWithCountsByLottoStatus());
        output.printProfitRate(lottoService.getPrintDataWithProfitRate());
    }

    private void order() {
        inputAmount();
        int manualQuantity = inputManualAmount();
        inputManualLottos(manualQuantity);

        lottoService.createLottos();
        output.printOrderResult(lottoService.countByOrderType());
    }

    private void inputAmount() {
        try {
            output.printAmountMessage();
            orderService.createOrder(input.inputAmount());
        } catch (IllegalArgumentException iae) {
            output.printMessage(iae.getMessage());
            inputAmount();
        }
    }

    private int inputManualAmount() {
        try {
            output.printManualLottoAmountMessage();
            int manualQuantity = input.inputManualQuantity();

            orderService.addManualQuantity(manualQuantity);
            return manualQuantity;
        } catch (IllegalArgumentException iae) {
            output.printMessage(iae.getMessage());
            return inputManualAmount();
        }
    }

    private void inputManualLottos(int manualQuantity) {
        try {
            output.printManualLottosMessage(manualQuantity);
            while (orderService.canOrderManualLotto()) {
                orderService.addManualLotto(input.inputManualLotto());
            }
        } catch (IllegalArgumentException iae) {
            output.printMessage(iae.getMessage());
            inputManualLottos(manualQuantity);
        }
    }

    private void inputWinningNumbers() {
        try {
            output.printWinningNumbersMessage();
            lottoService.createWinningLotto(input.inputWinningNumbers());
        } catch (IllegalArgumentException iae) {
            output.printMessage(iae.getMessage());
            inputWinningNumbers();
        }
    }

    private void inputBonusBall() {
        try {
            output.printBonusBallMessage();
            lottoService.addBonusBall(input.inputBonusBall());
        } catch (IllegalArgumentException iae) {
            output.printMessage(iae.getMessage());
            inputBonusBall();
        }
    }

}
