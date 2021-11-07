package lotto.ui;

public class ConsoleInputView implements InputView {

    @Override
    public String readAmount() {
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

}
