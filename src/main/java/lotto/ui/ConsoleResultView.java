package lotto.ui;

import java.util.List;
import lotto.number.LottoNumbers;

public class ConsoleResultView implements ResultView{

    @Override
    public void printBoughtLottos(List<LottoNumbers> lottoNumbersList) {
        System.out.println(lottoNumbersList.size() + "개를 구매했습니다.");
        for(LottoNumbers LottoNumbers : lottoNumbersList){
            System.out.println(LottoNumbers);
        }
    }
}
