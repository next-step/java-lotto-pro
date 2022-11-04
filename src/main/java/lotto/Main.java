package lotto;

import lotto.application.LottoSystem;

public class Main {

    public static void main(String[] args) {
        try (LottoSystem lottoSystem = LottoSystem.asDefault()) {
            lottoSystem.run();
        }
    }
}
