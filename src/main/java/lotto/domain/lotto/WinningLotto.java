package lotto.domain.lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.domain.win.WinRanking;
import lotto.message.ErrorMessages;

public class WinningLotto {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        validateBonusNumberNotInWinningNumbers(winningNumbers, bonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public static WinningLotto of(List<Integer> winningNumbers, int inputBonusNumber) {
        return of(toWinningNumbers(winningNumbers), LottoNumber.from(inputBonusNumber));
    }

    private static List<LottoNumber> toWinningNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private static void validateBonusNumberNotInWinningNumbers(List<LottoNumber> winningNumbers,
                                                               LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format(ErrorMessages.DUPLICATED_BONUS_NUMBER, bonusNumber));
        }
    }

    public Map<WinRanking, Integer> winResults(Lottos lottos) {
        Map<WinRanking, Integer> winningCountByWinRanking = new EnumMap<>(WinRanking.class);

        for (Lotto lotto : lottos.getLottos()) {
            WinRanking winRanking = WinRanking.of(lotto.matches(winningNumbers), lotto.hasBonusNumber(bonusNumber));
            int count = winningCountByWinRanking.getOrDefault(winRanking, LottoConstant.EMPTY_WINNING_COUNT);
            winningCountByWinRanking.put(winRanking, count + 1);
        }

        return winningCountByWinRanking;
    }
}
