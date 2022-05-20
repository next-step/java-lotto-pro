package lotto.model;

import java.util.EnumMap;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRank;

public class WinningLotto {

    private static final int NONE = 0;
    private static final int MATCH = 1;

    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        validateDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplication(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_BONUS);
        }
    }

    public LottoGameResult compareLottos(Lottos lottos) {
        EnumMap<LottoRank, Integer> resultRank = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos.getLottos()) {
            LottoRank lottoRank = lotto.matchRank(winningNumbers, bonusNumber);
            resultRank.put(lottoRank, resultRank.getOrDefault(lottoRank, NONE) + MATCH);
        }
        return new LottoGameResult(resultRank);
    }
}
