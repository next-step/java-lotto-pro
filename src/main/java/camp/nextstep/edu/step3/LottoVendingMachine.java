package camp.nextstep.edu.step3;

import java.util.*;

public class LottoVendingMachine {
    private final LottoGenerator generator;
    private IssuedHistory latestIssuedHistory;

    public LottoVendingMachine(final LottoGenerator generator) {
        this.generator = generator;
    }

    public LottoPaper issued(final LottoMoney money) {
        List<Lotto> autoLotto = buyLotto(money);
        updateIssuedHistory(Collections.singletonList(new IssuedInformation(IssuedMode.Auto, autoLotto)));
        return new LottoPaper(buyLotto(money));
    }

    public LottoPaper issued(final LottoMoney money, List<Lotto> manualLotto) {
        if (isAllAuto(manualLotto)) {
            return this.issued(money);
        }
        if (isAllManual(money.excludingAmount(manualLotto))) {
            updateIssuedHistory(Collections.singletonList(new IssuedInformation(IssuedMode.Manual, manualLotto)));
            return new LottoPaper(manualLotto);
        }

        return issuedManualWithAuto(money.excludingAmount(manualLotto), manualLotto);
    }

    public LottoPaper issuedManualWithAuto(LottoMoney money, List<Lotto> manualLotto) {
        List<Lotto> automaticallyIssuedLotto = buyLotto(money);
        updateIssuedHistory(Arrays.asList(
                new IssuedInformation(IssuedMode.Auto, automaticallyIssuedLotto),
                new IssuedInformation(IssuedMode.Manual, manualLotto)
        ));
        return new LottoPaper(totalLotto(manualLotto, automaticallyIssuedLotto));
    }

    public IssuedHistory printIssuedLotto() {
        if (Objects.isNull(latestIssuedHistory)) {
            throw new IllegalStateException("발급기록이 없습니다.");
        }
        return latestIssuedHistory;
    }

    private List<Lotto> totalLotto(final List<Lotto> manualLotto, final List<Lotto> automaticallyIssuedLotto) {
        List<Lotto> totalLotto = new ArrayList<>();
        totalLotto.addAll(manualLotto);
        totalLotto.addAll(automaticallyIssuedLotto);
        return totalLotto;
    }

    private boolean isAllAuto(List<Lotto> manualLotto) {
        return Objects.isNull(manualLotto) || manualLotto.isEmpty();
    }

    private boolean isAllManual(final LottoMoney lottoMoney) {
        return Objects.equals(lottoMoney, new LottoMoney(0));
    }

    private void updateIssuedHistory(List<IssuedInformation> issuedInformationList) {
        this.latestIssuedHistory = new IssuedHistory(issuedInformationList);
    }

    private List<Lotto> buyLotto(LottoMoney money) {
        return extractLottoByAuto(money);
    }

    private List<Lotto> extractLottoByAuto(LottoMoney money) {
        List<Lotto> lottoList = new ArrayList<>();
        while (money.isBuyable()) {
            money = money.buy();
            lottoList.add(generator.auto());
        }
        return lottoList;
    }
}
