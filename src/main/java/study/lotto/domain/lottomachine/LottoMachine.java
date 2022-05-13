package study.lotto.domain.lottomachine;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    public List<Lotto> issueLotto(BigDecimal money) {
        if (Objects.isNull(money)) {
            return new ArrayList<>();
        }
        return issue(money);
    }

    private List<Lotto> issue(BigDecimal money) {
        int count = lottoPrice.maximumIssuableCount(money);
        return IntStream.range(0, count).mapToObj(i -> generateLotto()).collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        return new Lotto(lottoGenerator.generate());
    }
}
