package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//구매 금액만큼 로또를 발급하는 역할을 가진 클래스
public class LottoStore {

    private LottoStore() {
    }

    public static Lottos purchase(final Money money, final int manualPurchaseCount, final List<List<Integer>> manualLottoNumber) {
        List<Lotto> lottos = new ArrayList<>();
        if (isExistManualLotto(manualPurchaseCount)) {
            manualLottoCountCheck(manualPurchaseCount, manualLottoNumber);
            manualLottoMoneyExcessCheck(manualPurchaseCount, money);
            lottos.addAll(createManualLottos(manualLottoNumber));
        }
        int autoIssuanceCount = money.divide() - manualPurchaseCount;
        lottos.addAll(createAutoLottos(autoIssuanceCount));
        return new Lottos(lottos);
    }

    private static List<Lotto> createAutoLottos(final int autoIssuanceCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < autoIssuanceCount; i++) {
            List<Integer> generatedLottoNumbers = LottoNumberGenerator.generator();

            List<LottoNumber> lottoNumbers = generatedLottoNumbers.stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());

            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    public static List<Lotto> createManualLottos(final List<List<Integer>> manualLottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        
        for (int i = 0; i < manualLottoNumbers.size(); i++) {
            lottos.add(manualLottoNumbers.get(i).stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)));
        }

        return lottos;
    }

    private static void manualLottoCountCheck(final int lottoManualPurchaseCount, final List<List<Integer>> manualLottoNumbers) {
        if (lottoManualPurchaseCount != manualLottoNumbers.size()) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수와 로또의 개수가 일치하지 않습니다.");
        }
    }

    private static void manualLottoMoneyExcessCheck(final int lottoManualPurchaseCount, final Money money) {
        if (money.divide() - lottoManualPurchaseCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 로또 구입금액을 초과하였습니다.");
        }
    }

    private static boolean isExistManualLotto(final int manualPurchaseCount) {
        return manualPurchaseCount > 0;
    }
}
