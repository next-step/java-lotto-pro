package step3.model.machine;

import java.util.ArrayList;
import java.util.List;
import step3.model.lotto.Lotto;
import step3.model.lotto.LottoList;
import step3.model.value.Rule;


// 로또 머신은 로또를 생성하는 기능을 담당한다.
public class LottoMachine {
    private final LottoAutoGenerator autoGenerator;
    private final LottoManualGenerator manualGenerator;
    public LottoMachine(LottoAutoGenerator autoGenerator) {
        this.autoGenerator = autoGenerator;
        this.manualGenerator = new LottoManualGenerator();
    }

    public LottoList issueAutoLottoList(Order order) {
        List<Lotto> lottoList = new ArrayList<>();
        int ticketCount = order.getAutoTicketCount();

        for (int i=0; i< ticketCount; i++) {
            lottoList.add(new Lotto(autoGenerator.generateLottoAuto(Rule.LOTTO_NUMBER_LENGTH)));
        }
        return new LottoList(lottoList);
    }
    public Lotto createWinningLotto(String input) {
        List<Integer> lotto = manualGenerator.createLotto(input);
        return new Lotto(lotto);
    }
}
