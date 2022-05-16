package domain;

public class RandomLottoFactory implements LottoFactory{

    @Override
    public Lotto make() {
        return new Lotto(LottoNumber.randomNumbers(Lotto.LOTTO_SELECTABLE_SIZE));
    }
}
