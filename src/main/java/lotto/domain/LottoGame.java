package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoGameDTO;
import lotto.exception.LottoCountLimitException;
import lotto.util.LottoNumbersGenerator;

public class LottoGame {

    private static final int LOOP_START_VALUE = 0;
    private static final int DEFAULT_COUNT = 0;
    private final List<LottoLine> lottoGame;

    public LottoGame(List<LottoLine> lottoGame) {
        this.lottoGame = lottoGame;
    }

    public static LottoGame issueLotto(int totalCount, int pickCount) {
        int autoCount = totalCount - pickCount;
        if (autoCount < DEFAULT_COUNT) {
            throw new LottoCountLimitException();
        }
        List<LottoLine> lottoLines = new ArrayList<>();
        for (int i = LOOP_START_VALUE; i < autoCount; i++) {
            List<Integer> lottoNumbers = LottoNumbersGenerator.generateLottoNumbers();
            lottoLines.add(new LottoLine(lottoNumbers));
        }
        return new LottoGame(lottoLines);
    }

    public static LottoGame joinLottoGame(LottoGame source, LottoGame destination) {
        source.lottoGame.addAll(destination.lottoGame);
        return source;
    }

    public void addLottoLine(LottoLine lottoLine) {
        lottoGame.add(lottoLine);
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
