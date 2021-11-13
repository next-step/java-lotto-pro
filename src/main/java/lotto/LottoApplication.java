package lotto;

import lotto.ui.LottoController;

public class LottoApplication {

    public static void main(String[] args) {
        try {
            LottoController.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
