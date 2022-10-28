package lotto.dto;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class LottoBill {
    private final int lottoPiece;
    private final List<Lotto> lottos;

    public LottoBill(int lottoCount, List<Lotto> lottos) {
        this.lottoPiece = lottoCount;
        this.lottos = lottos;
    }

    public int getLottoPiece() {
        return lottoPiece;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
