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

    public List<Lotto> issueAutoLottoList(Order order) {
        List<Lotto> lottoList = new ArrayList<>();
        int ticketCount=0;
        while(order.leftToTicketing(ticketCount)){
            ticketCount+=1;
            lottoList.add(new Lotto(autoGenerator.generateLottoAuto(Rule.LOTTO_NUMBER_LENGTH)));
        }
        return lottoList;
    }
    public List<Integer> createWinningLotto(String input) {
        return manualGenerator.createLotto(input);
    }
}
