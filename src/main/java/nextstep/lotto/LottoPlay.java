package nextstep.lotto;

import nextstep.lotto.service.LottoService;

public class LottoPlay {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.startLotto();
    }
}
