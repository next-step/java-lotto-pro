package lotto.model;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRank;
import lotto.constant.LottoRoleConst;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public WinningLotto(List<Integer> winningNumbers, LottoNumber bonusNumber) {
        this(winningNumbers);
        validateDuplication(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNumberSize(winningNumbers);
        validateDuplication(winningNumbers);
        for (int winningNumber : winningNumbers) {
            validateLottoNumber(winningNumber);
        }
    }

    private static void validateNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoRoleConst.LOTTO_NUMBER_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NON_SIX_NUMBERS);
        }
    }

    private static void validateDuplication(List<Integer> winningNumbers) {
        HashSet<Integer> deleteDuplicationNumber = new HashSet<>(winningNumbers);
        if (winningNumbers.size() != deleteDuplicationNumber.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION);
        }
    }

    private void validateDuplication(List<Integer> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_BONUS);
        }
    }

    private static void validateLottoNumber(int winningNumber) {
        if (winningNumber < LottoRoleConst.LOW_NUMBER || winningNumber > LottoRoleConst.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER);
        }
    }

    public LottoGameResult compareLottos(Lottos lottos) {
        EnumMap<LottoRank, Integer> resultRank = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos.getLottos()) {
            LottoRank lottoRank = lotto.matchRank(winningNumbers, bonusNumber);
            resultRank.put(lottoRank, resultRank.getOrDefault(lottoRank, 0) + 1);
        }
        return new LottoGameResult(resultRank);
    }
}
