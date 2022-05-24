package lotto.domain;

public class LottoRandomFactory {
    private final RandomNumberMachine randomNumberMachine;

    public LottoRandomFactory(RandomNumberMachine randomNumberMachine) {
        this.randomNumberMachine = randomNumberMachine;
    }

    public Lotto create() {
        LottoNumber[] lottoNumbers = new LottoNumber[Lotto.SIZE];
        for (int index = 0; index < Lotto.SIZE; index++) {
            lottoNumbers[index] = randomNumberMachine.popRandomNumber();
        }
        randomNumberMachine.refill();

        return new Lotto(lottoNumbers);
    }
}
