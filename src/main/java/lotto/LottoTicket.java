package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    public static final int PRICE = 1000;
    private final List<LottoGame> lottoGames;

    public LottoTicket(final int money) {
        validate(money);
        List<LottoGame> lottoGames = new ArrayList<>();
        for (int i = 0; i < money / PRICE; i++) {
            lottoGames.add(new LottoGame(LottoNumbersGenerator.generate(1, 45, 6)));
        }
        this.lottoGames = lottoGames;
    }

    public int size() {
        return lottoGames.size();
    }

    private void validate(final int money) {
        if (money / PRICE <= 0) {
            throw new IllegalArgumentException("잘못된 금액");
        }
    }
}
