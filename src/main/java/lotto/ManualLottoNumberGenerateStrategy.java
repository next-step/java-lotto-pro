package lotto;

public class ManualLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {

    private final int number;

    public ManualLottoNumberGenerateStrategy(int number) {
        this.number = number;
    }

    @Override
    public LottoNumber generate() {
        return LottoNumber.valueOf(this.number);
    }
}
