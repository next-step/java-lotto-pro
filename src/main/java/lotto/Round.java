package lotto;

import static java.util.Objects.requireNonNull;

import generic.Rate;

public class Round {


    private enum RoundStatus {PLAYING, END;}
    private final Lottos lottos;

    private LottoNumbers winningNumbers;

    private RoundStatus status;

    private LottoWinStatistics statics;

    private Round(final Lottos lottos) {
        this.lottos = lottos;
        this.status = RoundStatus.PLAYING;
    }

    public static Round start(final Lottos lottos) {
        validateStart(requireNonNull(lottos));
        return new Round(lottos);
    }

    private static void validateStart(final Lottos lottos) {
        if (lottos.size() < 1) {
            throw new IllegalArgumentException("로또가 없습니다.");
        }
    }

    public void end(final LottoNumbers winningNumbers) {
        validateEnd(requireNonNull(winningNumbers));
        this.winningNumbers = winningNumbers;
        this.status = RoundStatus.END;
        this.statics = new LottoWinStatistics(lottos.purchasePrice(), lottos.end(winningNumbers));
    }

    private void validateEnd(final LottoNumbers winningNumbers) {
        if (!winningNumbers.isPicked()) {
            throw new IllegalArgumentException("당첨 번호가 선택되지 않았습니다.");
        }
    }

    public int purchaseSize() {
        return lottos.size();
    }

    public Lottos lottos() {
        return this.lottos;
    }

    public Rate totalReturnRate() {
        if (status != RoundStatus.END) {
            throw new IllegalStateException("완료 상태가 아닙니다.");
        }

        return statics.getReturnRate();
    }

    public long countByWinResult(final LottoWinResult lottoWinResult) {
        return this.statics.countByWinResult(lottoWinResult);
    }

    public boolean isPaying() {
        return this.status == RoundStatus.PLAYING;
    }

    public boolean isEnd() {
        return this.status == RoundStatus.END;
    }

    public boolean isLoss() {
        return this.statics.isLoss();
    }
}
