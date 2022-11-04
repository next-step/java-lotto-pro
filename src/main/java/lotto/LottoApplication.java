package lotto;

import lotto.controller.LottoController;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        try {
            new LottoController().run();
        } catch (IllegalArgumentException e) {
            OutputView.print("[ERROR] : " + e.getMessage());
            OutputView.print("프로그램을 종료합니다.");
        }
    }
}
