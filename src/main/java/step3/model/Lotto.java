package step3.model;

public class Lotto {
    private final LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        validateNull(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNull(LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new RuntimeException("행운의번호가 널입니다.");
        }
    }

    public int getMatchedCount(LottoWinningNumber lottoWinning) {
        return lottoWinning.getMatchedCount(lottoNumber);
    }

    public boolean isMatchedBonus(LottoWinningNumber winningLotto) {
        return winningLotto.isMatchedBonus(lottoNumber);
    }
}
