package study.lottoAuto;

public class StaticsController {

    private final int COUNT_BASE = 3;

    private final Statics statics;
    private final LottoNumbersGroup lottoNumbersGroup;
    private final LottoNumbers lastLottoNumbers;

    public StaticsController(Money userInputMoney, LottoNumbersGroup lottoNumbersGroup, LottoNumbers lastLottoNumbers) {
        this.statics = new Statics(userInputMoney);
        this.lottoNumbersGroup = lottoNumbersGroup;
        this.lastLottoNumbers = lastLottoNumbers;
    }

    public void analyst() {
        for(LottoNumbers lottoNumbers : lottoNumbersGroup.getLottoNumbersList()) {
            writeResult(lastLottoNumbers.getMatchCount(lottoNumbers));
        }
        statics.calculateProfitRate();
    }

    private void writeResult(final int result) {
        if(result >= COUNT_BASE) {
            statics.renew(result);
        }
    }

    public Statics getStatics() {
        return this.statics;
    }
}
