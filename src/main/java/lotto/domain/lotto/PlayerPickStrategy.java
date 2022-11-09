package lotto.domain.lotto;

import static lotto.utils.Validations.requireNotNull;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerPickStrategy implements NumberPickStrategy {
    private final List<LottoNumbers> pickedNumbers;

    public PlayerPickStrategy(final List<LottoNumbers> picks) {
        requireNotNull(picks, "선택번호 목록은 null이 아니어야 합니다.");
        picks.forEach(numbers -> requireNotNull(numbers, "선택번호 목록 내 null이 포함되지 않아야 합니다."));
        this.pickedNumbers = picks;
    }

    @Override
    public List<LottoNumbers> pickNumbers(int quantity) {
        return pickedNumbers.stream()
                .limit(quantity)
                .collect(Collectors.toList());
    }
}
