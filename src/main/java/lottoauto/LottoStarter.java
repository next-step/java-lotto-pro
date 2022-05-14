package lottoauto;

import lottoauto.domain.LottoMaker;
import lottoauto.domain.WinnerChecker;
import lottoauto.util.InputUtil;
import lottoauto.wrapper.Lotto;
import lottoauto.domain.LottoList;

public class LottoStarter {
    private static LottoMaker lottoMaker;

    public void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        InputUtil inputUtil = new InputUtil();
        LottoList lottoList = new LottoList();
        lottoMaker = new LottoMaker(inputUtil.getInput());

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        inputUtil = new InputUtil();
        System.out.println(inputUtil.getInput());
        Lotto lotto = new Lotto(inputUtil.checkRegex());

        WinnerChecker winnerChecker = new WinnerChecker(lotto);
        winnerChecker.checkMatchNumbers();
    }
}
