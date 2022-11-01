package step3.domain.lotto;

public class BonusLottoNumber {

    private final LottoNumber lottoNumber;

    public BonusLottoNumber(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber value() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return "LottoBonusNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }
}
