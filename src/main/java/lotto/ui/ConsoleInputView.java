package lotto.ui;

public class ConsoleInputView implements InputView {

    @Override
    public String readPurchaseAmount() {
        return UIBufferedReaders.readLine();
    }

    @Override
    public String readWinLottoNumbers() {
        return UIBufferedReaders.readLine();
    }

    @Override
    public String readWinBonusLottoNumber() {
        return UIBufferedReaders.readLine();
    }

    @Override
    public String readManualLottosCount() {
        return UIBufferedReaders.readLine();
    }

    @Override
    public String readManualLottosNumber() {
        return UIBufferedReaders.readLine();
    }

}
