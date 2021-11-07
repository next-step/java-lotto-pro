package lotto.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCalculator {

    public static final int LOTTO_PRICE = 1_000;
    public static final int PROFIT_RATE = 1;

    private final Lottos lottos;
    private WinningResults winningResults;

    public LottoCalculator(PurchaseAmount purchaseAmount, Lottos manualLottos) {
        validate(purchaseAmount, manualLottos);
        this.lottos = generateLottos(purchaseAmount, manualLottos);
    }


    public LottoCalculator(PurchaseAmount purchaseAmount, WinningResults winningResults) {
        this(purchaseAmount, new Lottos(new ArrayList<>()));
        this.winningResults = winningResults;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public WinningResults getWinningResults() {
        return winningResults;
    }

    public void calculate(WinningLotto winningLotto) {
        this.winningResults = lottos.getWinningResults(winningLotto);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public float getProceedsRate() {
        return (float) winningResults.getProceeds() / ((float) getLottosSize() * LOTTO_PRICE);
    }

    private void validate(PurchaseAmount purchaseAmount, Lottos manualLottos) {
        if (!purchaseAmount.isAvailableManualQuantity(manualLottos)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_CALCULATOR_MANUAL_OVER_ERROR.getMessage());
        }
    }

    private Lottos generateLottos(PurchaseAmount purchaseAmount, Lottos manualLottos) {
        int autoQuantity = purchaseAmount.getQuantity() - manualLottos.size();
        return Lottos.of(manualLottos, getAutoLottos(autoQuantity));
    }

    private Lottos getAutoLottos(int autoQuantity) {
        return IntStream.range(0, autoQuantity)
                .mapToObj(ignore -> LottoGenerator.generate())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }
}
