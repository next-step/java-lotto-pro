package step3.model;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {
    public static final String SPLIT_REGEX = ",";

    private final WinningLotto winningLotto;
    private final WinningReport winningReport;

    public WinningResult(LottoPaper lottoPaper, String winningNumberString, int bonusNumber) {
        this.winningLotto = new WinningLotto(initWinningNumber(winningNumberString), new Number(bonusNumber));
        this.winningReport = lottoPaper.checkWinning(winningLotto);
    }

    private Lotto initWinningNumber(String winningNumberString) {
        List<Number> winningNumbers = new ArrayList<>();
        String[] winningNumbersArray = winningNumberString.split(SPLIT_REGEX);
        for (String winningNumber : winningNumbersArray) {
            winningNumbers.add(new Number(Integer.parseInt(winningNumber.trim())));
        }
        return new Lotto(winningNumbers);
    }

    public WinningReport winningReport() {
        return winningReport;
    }
}
