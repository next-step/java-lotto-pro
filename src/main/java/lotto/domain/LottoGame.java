package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoNumbersGenerator;
import lotto.util.LottoStringGenerator;
import lotto.view.InputView;

public class LottoGame {

    private static final int LOOP_START_VALUE = 0;
    private static final String LINE_BREAK = "\n";
    private final List<LottoLine> lottoGame;

    public LottoGame(List<LottoLine> lottoGame) {
        this.lottoGame = lottoGame;
    }

    public static LottoGame issueLotto(int totalCount, int pickCount) {
        int autoCount = totalCount - pickCount;
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

    public static LottoGame generateManualLottoGame(LottoCount manualLottoCount) {
        LottoGame manualLottoGame = new LottoGame(new ArrayList<>());
        for (int i = LOOP_START_VALUE; i < manualLottoCount.value();i++) {
            manualLottoGame.addLottoLine(
                LottoStringGenerator.toLottoLine(InputView.inputManualLottoLine())
            );
        }
        return manualLottoGame;
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

    public int size(){
        return lottoGame.size();
    }

    public String toLottoGameString() {
        List<String> lottoGameString = lottoGame.stream()
            .map(LottoLine::toString)
            .collect(Collectors.toList());
        return String.join(LINE_BREAK, lottoGameString);
    }

}
