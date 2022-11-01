package step3.model.dto;

import step3.model.Lotto;
import step3.model.LottoNumber;
import step3.model.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosNumberDto {

    private final List<List<Integer>> lottosNumber;
    private final int autoLottoCount;
    private final int manualLottoCount;

    public LottosNumberDto(Lottos lottoCollection) {
        List<Lotto> lottos = lottoCollection.getNumbersOfLottos();
        this.lottosNumber = lottos
                .stream()
                .map(Lotto::getNumbers)
                .map(lottoNumbers -> lottoNumbers.stream().map(LottoNumber::value).collect(Collectors.toList()))
                .collect(Collectors.toList());
        this.autoLottoCount = (int) lottos.stream().filter(Lotto::isAuto).count();
        this.manualLottoCount = this.lottosNumber.size() - this.autoLottoCount;
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
