package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManual {

    private final int purchaseCount;
    private List<Lotto> manualLotto;

    public LottoManual(final int lottoManualPurchaseCount, final Money money) {
        manualLottoMoneyExcessCheck(lottoManualPurchaseCount, money);
        this.purchaseCount = lottoManualPurchaseCount;
    }

    public LottoManual createLottos(final List<List<Integer>> manualLottoNumbers) {
        if (this.purchaseCount == 0) {
            manualLotto = new ArrayList<>();
            return this;
        }

        manualLottoCountCheck(manualLottoNumbers);
        List<Lotto> lottos = new ArrayList<>();

        for (int i=0; i<purchaseCount; i++) {
            lottos.add(manualLottoNumbers.get(i).stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)));
        }
        this.manualLotto = lottos;

        return this;
    }

    private void manualLottoCountCheck(final List<List<Integer>> manualLottoNumbers) {
        if (this.purchaseCount != manualLottoNumbers.size()) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수와 로또의 개수가 일치하지 않습니다.");
        }
    }

    private void manualLottoMoneyExcessCheck(final int lottoManualPurchaseCount, final Money money) {
        if (money.divide() - lottoManualPurchaseCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 로또 구입금액을 초과하였습니다.");
        }
    }

    public List<Lotto> getManualLotto() {
        return new ArrayList<>(manualLotto);
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
