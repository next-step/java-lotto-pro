package lotto.controller.converter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoResultDTO;
import lotto.domain.LottoWinningResults;
import lotto.enums.LottoRank;

public class LottoResultDTOConverter {

    public static LottoResultDTO convert(LottoWinningResults results) {
        LottoResultDTO resultDTO = new LottoResultDTO();
        Map<LottoRank, Integer> resultMap = new LinkedHashMap<>();
        List<LottoRank> prizedRanks = LottoRank.getPrizedRanks();
        for (LottoRank prizedRank : prizedRanks) {
            resultMap.put(prizedRank, results.winningRankCount(prizedRank));
        }
        resultDTO.setResultMap(resultMap);
        return resultDTO;
    }
}
