package lotto.domain;

public class ManualLottoGenerator implements LottoGenerator {

    private final ManualLottoNumbers lottoNumbers;

    public ManualLottoGenerator(ManualLottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public Lottos generate() {
        return lottoNumbers.convertLottos();
    }
}
