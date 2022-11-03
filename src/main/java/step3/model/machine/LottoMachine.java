package step3.model.machine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import step3.model.lotto.Lotto;
import step3.model.lotto.LottoList;
import step3.model.lotto.LottoNumber;
import step3.model.lotto.WinningLotto;
import step3.model.value.ErrMsg;


// 로또 머신은 로또를 생성하는 기능을 담당한다.
public class LottoMachine {
    private final LottoAutoGenerator autoGenerator;
    private final LottoManualGenerator manualGenerator;
    public LottoMachine(LottoAutoGenerator autoGenerator) {
        this.autoGenerator = autoGenerator;
        this.manualGenerator = new LottoManualGenerator();
    }

    public LottoList issueLottoList(Order order, List<String> manualInputs) {
        int autoCount = order.getAutoTicketCount();
        List<Lotto> manualList = issueManualLottoList(manualInputs);
        List<Lotto> autoList = issueAutoLottoList(autoCount);
        List<Lotto> combineList = Stream.of(manualList, autoList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return new LottoList(combineList);
    }

    private List<Lotto> issueAutoLottoList(int autoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i=0; i< autoCount; i++) {
            lottoList.add(new Lotto(autoGenerator.generateLottoAuto()));
        }
        return lottoList;
    }
    private List<Lotto> issueManualLottoList(List<String> manualInputs) {
        return manualInputs.stream().map(manualGenerator::createLotto).collect(Collectors.toList());
    }
    public WinningLotto createWinningLotto(String lottoInput, int bonusInput) {
        Lotto lotto = manualGenerator.createLotto(lottoInput);
        return new WinningLotto(lotto, new LottoNumber(bonusInput));
    }
}
