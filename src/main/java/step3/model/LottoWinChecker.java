package step3.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import step3.domain.LottoElement;
import step3.domain.LottoTicket;
import step3.enums.LottoReward;
import step3.utls.NumberUtil;

public class LottoWinChecker {

    private LottoElement bonusNumber;
    private LottoTicket winnerLottoTicket;
    private static final String SET_BONUS_NUMBER_EXCEPTION_MSG = "정답티켓과 다른 번호를 설정해야합니다";
    public static final int MATCH = 1;
    public static final int NOT_MATCH = 0;
    private static final int MATCH_COUNT_BASE = 0;

    public void setBonusNumber(String lottoElementSource) {
        LottoElement bonusLottoElement = new LottoElement(NumberUtil.parseInt(lottoElementSource));
        validateBonusNumber(bonusLottoElement);
        bonusNumber = bonusLottoElement;
    }

    private void validateBonusNumber(LottoElement bonusLottoElement) {
        int isExist = 1;

        int bonusExistInWinnerTicket = winnerLottoTicket.getMatchCountWith(
            Arrays.asList(bonusLottoElement));

        if (bonusExistInWinnerTicket == isExist) {
            throw new IllegalArgumentException(LottoWinChecker.SET_BONUS_NUMBER_EXCEPTION_MSG);
        }
    }

    public void setWinnerLottoTicket(LottoTicket winnerLottoTicket) {
        this.winnerLottoTicket = winnerLottoTicket;
    }

    public Map<LottoReward, Integer> checkWin(List<LottoTicket> userLottoTickets) {
        LinkedHashMap<LottoReward, Integer> statistics = new LinkedHashMap<>();
        initStatistics(statistics);
        for (LottoTicket lottoTicket : userLottoTickets) {
            int matchCountWithUserAndWinnerLotto = lottoTicket.getMatchCountWith(
                winnerLottoTicket.getLottoNumbers());

            boolean haveBonusNumberInUserLottoTicket =
                lottoTicket.getMatchCountWith(Arrays.asList(bonusNumber)) == LottoWinChecker.MATCH;

            LottoReward lottoReward = LottoReward.valueOf(matchCountWithUserAndWinnerLotto,
                haveBonusNumberInUserLottoTicket);

            statistics.replace(lottoReward, statistics.get(lottoReward) + LottoWinChecker.MATCH);
        }
        return statistics;
    }

    private void initStatistics(LinkedHashMap<LottoReward, Integer> statistics) {
        for (LottoReward lottoReward : LottoReward.values()) {
            statistics.put(lottoReward, LottoWinChecker.MATCH_COUNT_BASE);
        }
    }
}
