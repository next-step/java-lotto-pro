package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoGame;
import lotto.view.LottoView;

public class ManualLottoController extends LottoController {

    private String manualLottoCount;

    public ManualLottoController(LottoGame lottoGame, LottoView view, Runnable bonusStrategy) {
        super(lottoGame, view, bonusStrategy);
    }

    @Override
    public void createLottoNumbers() {
        List<Runnable> createManualLottoNumbers = createManualLottoNumbers();
        createManualLottoNumbers.forEach(runnable -> {
            while (isNotComplete(runnable)) {
            }
        });

    }

    private List<Runnable> createManualLottoNumbers() {
        return Arrays.asList(
                () -> lottoGame.createPurchase(view.readPurchase()),
                () -> {
                    manualLottoCount = view.readManualLottoCount();
                    lottoGame.createManualLottoNumbers(manualLottoCount);
                },
                () -> {
                    lottoGame.addManualLottoNumbers(view.readManualLottoNumber(Integer.parseInt(manualLottoCount)));
                    view.printLottoNumbers(lottoGame.makeLottoNumbersResult());
                }
        );
    }
}
