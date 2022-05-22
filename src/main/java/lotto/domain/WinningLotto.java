package lotto.domain;

import lotto.enums.LottoRank;

public class WinningLotto {
    private static final String ERROR_MESSAGE_WINNING_LOTTO_NULL = "[ERROR] referenceLotto is null.";
    private static final String ERROR_MESSAGE_BONUS_NUMBER_NULL = "[ERROR] bonusNumber is null.";
    private static final String ERROR_MESSAGE_MATCHING_LOTTO_NULL = "[ERROR] lotto for matching is null.";

    private final Lotto referenceLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto referenceLotto, LottoNumber bonusNumber) {
        validate(referenceLotto, bonusNumber);

        this.referenceLotto = referenceLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(Lotto lotto) {
        validateMatch(lotto);

        int countOfMatch = 0;
        for (int index = 0; index < referenceLotto.size(); index++) {
            countOfMatch += countOneLottoHasNumber(lotto, referenceLotto.get(index));
        }

        final LottoMatchingResult result = new LottoMatchingResult(countOfMatch, lotto.hasNumber(bonusNumber));
        return result.convertToLottoRank();
    }

    private int countOneLottoHasNumber(Lotto lotto, LottoNumber lottoNumber) {
        if (lotto.hasNumber(lottoNumber)) {
            return 1;
        }

        return 0;
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        validateWinningLotto(winningLotto);
        validateBonusNumber(bonusNumber);
    }

    private void validateWinningLotto(Lotto winningLotto) {
        if (winningLotto == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WINNING_LOTTO_NULL);
        }
    }

    private void validateBonusNumber(LottoNumber bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_NULL);
        }
    }

    private void validateMatch(Lotto lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MATCHING_LOTTO_NULL);
        }
    }
}
