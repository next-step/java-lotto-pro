package lotto.domain;

public class LottoRandomFactory {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final RandomNumberMachine randomNumberMachine;

    public LottoRandomFactory(RandomNumberMachine randomNumberMachine) {
        this.randomNumberMachine = randomNumberMachine;
    }

    public Lotto create() {
        LottoNumber[] lottoNumberList = new LottoNumber[LOTTO_NUMBER_SIZE];
        for (int index = 0; index < LOTTO_NUMBER_SIZE; index++) {
            lottoNumberList[index] = randomNumberMachine.popRandomNumber();
        }
        randomNumberMachine.refill();

        return new Lotto(lottoNumberList);
    }
}
