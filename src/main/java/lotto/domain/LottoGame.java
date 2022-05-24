package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoGameDTO;
import lotto.util.LottoNumbersGenerator;

public class LottoGame {

    private static final int LOOP_START_VALUE = 0;
    private final List<LottoLine> lottoGame;

    public LottoGame(List<LottoLine> lottoGame) {
        this.lottoGame = lottoGame;
    }

    public static LottoGame issueLotto(int totalCount) {
        List<LottoLine> lottoLines = new ArrayList<>();
        for (int i = LOOP_START_VALUE; i < totalCount; i++) {
            List<Integer> lottoNumbers = LottoNumbersGenerator.generateLottoNumbers();
            lottoLines.add(new LottoLine(lottoNumbers));
        }
        return new LottoGame(lottoLines);
    }

    public LottoResult getLottoResult(LottoLine winLottoLine, LottoNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (LottoLine lottoLine : lottoGame) {
            lottoResult.add(lottoLine.getMatchCount(winLottoLine, bonusNumber));
        }
        return lottoResult;
    }

    public LottoGameDTO toLottoGameDTO() {
        return new LottoGameDTO(lottoGame
            .stream()
            .map(LottoLine::toLottoLineDTO)
            .collect(Collectors.toList()));
    }

}
