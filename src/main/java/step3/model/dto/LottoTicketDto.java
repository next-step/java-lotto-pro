package step3.model.dto;

import step3.model.Lotto;
import step3.model.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDto {


    private final List<List<Integer>> lottosNumber;
    private final int autoLottoCount;
    private final int manualLottoCount;

    public LottoTicketDto(List<Lotto> lottos) {
        this.lottosNumber = createLottoNumbers(lottos);
        autoLottoCount = (int) lottos.stream().filter(Lotto::isAuto).count();
        manualLottoCount = lottos.size() - autoLottoCount;
    }

    private List<List<Integer>> createLottoNumbers(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList())
                .stream()
                .map(lottoNumbers -> lottoNumbers.stream().map(LottoNumber::value).collect(Collectors.toList()))
                .collect(Collectors.toList());
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
