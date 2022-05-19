package study.lotto.domain.lottomachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import study.lotto.domain.Lotto;
import study.lotto.domain.Lottos;

public class LottoMachine {
    static final BigDecimal DEFAULT_LOTTO_PRICE = BigDecimal.valueOf(1000);

    private final LottoGenerator lottoGenerator;
    private final Price lottoPrice;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this(lottoGenerator, new Price(DEFAULT_LOTTO_PRICE));
    }

    public LottoMachine(LottoGenerator lottoGenerator, Price lottoPrice) {
        this.lottoGenerator = lottoGenerator;
        this.lottoPrice = lottoPrice;
    }

    public LottoPurchaseHistory issueLotto(Price purchasePrice) {
        if (Objects.isNull(purchasePrice)) {
            throw new IllegalArgumentException("구매 금액이 null이 될 수 없습니다.");
        }
        return issue(purchasePrice, new Lottos(new ArrayList<>()));
    }

    public LottoPurchaseHistory issueLotto(Price purchasePrice, Lottos lotto) {
        if (Objects.isNull(purchasePrice)) {
            throw new IllegalArgumentException("구매 금액이 null이 될 수 없습니다.");
        }
        return issue(purchasePrice, lotto);
    }

    private LottoPurchaseHistory issue(Price purchasePrice, Lottos manualLottos) {
        LottoCount totalCount = numberOfLottos(purchasePrice);

        LottoCount manualCount = manualLottos.getManualCount();
        if (manualCount.isGreaterThan(totalCount)) {
            throw new IllegalArgumentException(String.format("입력한 금액으로는 최대 %s개의 로또를 구매할 수 있습니다.", totalCount));
        }

        int automaticLottoCount = totalCount.subtract(manualCount);
        Lottos issuedLotto = generateLottos(manualLottos, automaticLottoCount);
        BigDecimal totalPrice = lottoPrice.multiply(totalCount.get());

        return new LottoPurchaseHistory(issuedLotto, totalPrice);
    }

    private LottoCount numberOfLottos(Price money) {
        int count = money.divide(lottoPrice);
        if (count <= 0) {
            throw new IllegalArgumentException("로또를 하나도 구입하지 못했습니다.");
        }
        return new LottoCount(count);
    }

    private Lottos generateLottos(Lottos manualLottos, int automaticLottoCount) {
        List<Lotto> sortedManualLottos = manualLottos.get().stream()
                .map(lottoGenerator::sort)
                .map(Lotto::new)
                .collect(Collectors.toList());
        return new Lottos(
                manualLottos.getManualCount(),
                mergeLottos(sortedManualLottos, generateAutomaticLottos(automaticLottoCount)));
    }

    private List<Lotto> mergeLottos(List<Lotto> manualLotto, List<Lotto> automaticLottos) {
        return Stream.of(manualLotto, automaticLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<Lotto> generateAutomaticLottos(int count) {
        return Stream.generate(this::generateLotto)
                .limit(count)
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        return new Lotto(lottoGenerator.generate());
    }
}
