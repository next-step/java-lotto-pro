package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.config.LottoGameConfig.LOTTO_GAME_MAXIMUM_NUMBER;
import static lotto.config.LottoGameConfig.LOTTO_GAME_NUMBER_COUNT;

public class LottoNumberValidator {
    public static void validLottoNumber(int number) {
        if (number <= 0 || number > LOTTO_GAME_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("Lotto number는 1과 45 사이의 수여야 합니다.");
        }
    }

    public static void validLottoNumbers(List<Integer> numbers) {
        Set<Integer> duplicatedNumberChecker = new HashSet<>();
        for (Integer number : numbers) {
            validLottoNumber(number);
            duplicatedNumberChecker.add(number);
        }

        if (duplicatedNumberChecker.size() != LOTTO_GAME_NUMBER_COUNT) {
            throw new IllegalArgumentException("Lotto number는 중복되지 않은 숫자 6개입니다.");
        }
    }

    public static void validBonusBall(int bonusBall, List<Integer> numbers) {
        validLottoNumber(bonusBall);
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("bonusBall은 당첨번호와 중복되선 안됩니다.");
        }
    }
}
