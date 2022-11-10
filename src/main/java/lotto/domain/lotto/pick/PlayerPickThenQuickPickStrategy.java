package lotto.domain.lotto.pick;

import static lotto.utils.Validations.requireNotNull;

import java.util.stream.Stream;
import lotto.domain.lotto.LottoNumbers;

public class PlayerPickThenQuickPickStrategy implements NumberPickStrategy {
    private final CombinedNumberPickStrategy pickStrategy;

    public PlayerPickThenQuickPickStrategy(
            final PlayerPickStrategy playerPick,
            final QuickPickStrategy quickPick
    ) {
        requireNotNull(playerPick, "수동선택전략은 null이 아니어야 합니다.");
        requireNotNull(quickPick, "자동선택전략은 null이 아니어야 합니다.");

        this.pickStrategy = new CombinedNumberPickStrategy(
                playerPick,
                quickPick
        );
    }

    @Override
    public Stream<LottoNumbers> pickNumbers(int quantity) {
        return pickStrategy.pickNumbers(quantity);
    }
}
