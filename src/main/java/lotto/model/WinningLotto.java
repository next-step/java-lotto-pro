package lotto.model;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRank;
import lotto.constant.LottoRoleConst;

public class WinningLotto {

    private final List<Integer> winningNumberList;

    public WinningLotto(List<Integer> winningNumberList) {
        validateWinningNumberList(winningNumberList);
        this.winningNumberList = winningNumberList;
    }

    public static void validateWinningNumberList(List<Integer> winningNumberList) {
        validateNumberSize(winningNumberList);
        validateDuplication(winningNumberList);
        for (int winningNumber : winningNumberList) {
            validateLottoNumber(winningNumber);
        }
    }

    private static void validateNumberSize(List<Integer> winningNumberList) {
        if (winningNumberList.size() != LottoRoleConst.LOTTO_NUMBER_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NON_SIX_NUMBERS);
        }
    }

    private static void validateDuplication(List<Integer> winningNumberList) {
        HashSet<Integer> deleteDuplicationNumber = new HashSet<>(winningNumberList);
        if(winningNumberList.size() != deleteDuplicationNumber.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION);
        }
    }

    private static void validateLottoNumber(int winningNumber) {
        if (winningNumber < LottoRoleConst.LOW_NUMBER || winningNumber > LottoRoleConst.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER);
        }
    }

    public LottoGameResult compareLottos(Lottos lottos) {
        EnumMap<LottoRank, Integer> resultRankMap = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos.getLottoList()){
            LottoRank lottoRank = lotto.matchRank(winningNumberList);
            resultRankMap.put(lottoRank, resultRankMap.getOrDefault(lottoRank, 0) + 1);
        }
        return new LottoGameResult(resultRankMap);
    }
}
