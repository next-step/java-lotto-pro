package study.lotto.domain.lottomachine;

import java.math.BigDecimal;
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
        return issue(purchasePrice);
    }

    private LottoPurchaseHistory issue(Price purchasePrice) {
        int count = numberOfLottos(purchasePrice);

        BigDecimal totalPrice = lottoPrice.multiply(count);
        Lottos issuedLottos = new Lottos(generateLottos(count));

        return new LottoPurchaseHistory(issuedLottos, totalPrice);
    }

    private int numberOfLottos(Price money) {
        int count = money.divide(lottoPrice);
        if (count <= 0) {
            throw new IllegalArgumentException("로또를 하나도 구입하지 못했습니다.");
        }
        return count;
    }

    private List<Lotto> generateLottos(int count) {
        return Stream.generate(this::generateLotto)
                .limit(count)
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        return new Lotto(lottoGenerator.generate());
    }
}
