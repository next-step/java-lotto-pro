package step3.model.dto;

import step3.model.Lotto;
import step3.model.LottoMoney;
import step3.model.LottoNumber;
import step3.model.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatusDto {

    private final List<List<Integer>> lottosNumber;
    private final int autoLottoCount;
    private final int manualLottoCount;

    public LottoStatusDto(Lottos lottoCollection, LottoMoney lottoMoney) {
        List<Lotto> lottos = lottoCollection.getNumbersOfLottos();
        this.lottosNumber = lottos
                .stream()
                .map(Lotto::getNumbers)
                .map(lottoNumbers -> lottoNumbers.stream().map(LottoNumber::value).collect(Collectors.toList()))
                .collect(Collectors.toList());
        this.autoLottoCount = lottoMoney.getCountOfAutoPurchase();
        this.manualLottoCount = lottoMoney.getCountOfManualPurchase();
    }

    public List<List<Integer>> getLottosNumber() {
        return lottosNumber;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

}
