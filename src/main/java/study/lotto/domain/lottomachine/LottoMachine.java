package study.lotto.domain.lottomachine;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import study.lotto.domain.Lotto;

public class LottoMachine {
    private final LottoGenerator lottoGenerator;
    private final LottoPrice lottoPrice;

    public LottoMachine(LottoGenerator lottoGenerator, LottoPrice lottoPrice) {
        this.lottoGenerator = lottoGenerator;
        this.lottoPrice = lottoPrice;
    }

    public LottoPurchaseHistory issueLotto(BigDecimal money) {
        if (Objects.isNull(money)) {
            throw new IllegalArgumentException("금액이 null이 될 수 없습니다.");
        }
        return issue(money);
    }

    private LottoPurchaseHistory issue(BigDecimal money) {
        int count = numberOfLottos(money);
        List<Lotto> lottoList = IntStream.range(0, count).mapToObj(i -> generateLotto()).collect(Collectors.toList());
        return new LottoPurchaseHistory(lottoList, lottoPrice.total(count));
    }

    private int numberOfLottos(BigDecimal money) {
        int count = lottoPrice.maximumIssuableCount(money);
        if (count <= 0) {
            throw new IllegalArgumentException("로또를 하나도 구입하지 못했습니다.");
        }
        return count;
    }

    private Lotto generateLotto() {
        return new Lotto(lottoGenerator.generate());
    }
}
