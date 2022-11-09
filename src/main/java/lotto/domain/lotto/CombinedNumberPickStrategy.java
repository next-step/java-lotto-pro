package lotto.domain.lotto;

import static lotto.utils.Validations.requireNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CombinedNumberPickStrategy implements NumberPickStrategy {
    final List<NumberPickStrategy> strategies;

    public CombinedNumberPickStrategy(NumberPickStrategy... strategies) {
        requireNotEmpty(strategies);
        requireNotNullInArray(strategies);
        this.strategies = Arrays.asList(strategies);
    }

    private static void requireNotEmpty(NumberPickStrategy[] strategies) {
        if (strategies.length == 0) {
            throw new IllegalArgumentException("로또 번호 생성 전략은 하나 이상 존재해야 합니다.");
        }
    }

    private void requireNotNullInArray(NumberPickStrategy[] strategies) {
        for (final NumberPickStrategy strategy : strategies) {
            requireNotNull(strategy, "로또 번호 생성 전략은 null이 아니어야 합니다.");
        }
    }

    @Override
    public Stream<LottoNumbers> pickNumbers(int quantity) {
        return this.strategies.stream()
                .flatMap(strategy -> strategy.pickNumbers(quantity))
                .limit(quantity);
    }
}
