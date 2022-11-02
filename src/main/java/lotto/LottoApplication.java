package lotto;

import lotto.service.LottoService;

public class LottoApplication {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.execute();
    }
}
