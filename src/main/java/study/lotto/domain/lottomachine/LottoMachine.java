package study.lotto.domain.lottomachine;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import study.lotto.domain.Lotto;
import study.lotto.domain.Lottos;
import study.lotto.domain.lottomachine.sorter.LottoSorter;

public class LottoMachine {
    static final Price DEFAULT_LOTTO_PRICE = new Price(BigDecimal.valueOf(1000));

    private final LottoGenerator lottoGenerator;
    private final LottoSorter sorter;
    private final Price lottoPrice;

    public LottoMachine(LottoGenerator lottoGenerator, LottoSorter lottoSorter) {
        this(lottoGenerator, lottoSorter, DEFAULT_LOTTO_PRICE);
    }

    public LottoMachine(LottoGenerator lottoGenerator, LottoSorter lottoSorter, Price lottoPrice) {
        this.lottoGenerator = lottoGenerator;
        this.sorter = lottoSorter;
        this.lottoPrice = lottoPrice;
    }

    public LottoPurchaseHistory issueLotto(Price purchasePrice) {
        return issueLotto(purchasePrice, new Lottos());
    }

    public LottoPurchaseHistory issueLotto(Price purchasePrice, Lottos manualLottos) {
        if (Objects.isNull(purchasePrice)) {
            throw new IllegalArgumentException("구매 금액이 null이 될 수 없습니다.");
        }
        return issue(purchasePrice, manualLottos);
    }

    private LottoPurchaseHistory issue(Price purchasePrice, Lottos manualLottos) {
        LottoCount totalCount = numberOfLottos(purchasePrice);

        LottoCount manualCount = manualLottos.count();
        if (manualCount.isGreaterThan(totalCount)) {
            throw new IllegalArgumentException(String.format("입력한 금액으로는 최대 %s개의 로또를 구매할 수 있습니다.", totalCount));
        }

        LottoCount automaticLottoCount = totalCount.subtract(manualCount);
        Lottos issuedLotto = generateLottos(manualLottos, automaticLottoCount);
        BigDecimal totalPrice = lottoPrice.multiply(totalCount.get());

        return new LottoPurchaseHistory(issuedLotto, manualCount, totalPrice);
    }

    private LottoCount numberOfLottos(Price money) {
        int count = money.divide(lottoPrice);
        if (count <= 0) {
            throw new IllegalArgumentException("로또를 하나도 구입하지 못했습니다.");
        }
        return new LottoCount(count);
    }

    private Lottos generateLottos(Lottos manualLottos, LottoCount automaticLottoCount) {
        return new Lottos(mergeLottos(manualLottos.get(), generateAutomaticLottos(automaticLottoCount)));
    }

    private List<Lotto> mergeLottos(List<Lotto> manualLotto, List<Lotto> automaticLottos) {
        return Stream.of(manualLotto, automaticLottos)
                .flatMap(Collection::stream)
                .map(sorter::sort)
                .collect(Collectors.toList());
    }

    private List<Lotto> generateAutomaticLottos(LottoCount count) {
        return Stream.generate(this::generateLotto)
                .limit(count.get())
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        return new Lotto(lottoGenerator.generate());
    }
}
