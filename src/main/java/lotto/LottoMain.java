package lotto;

import com.sun.tools.internal.ws.wsdl.document.Output;
import lotto.domain.Lotto;
import lotto.domain.LottoCreator;
import lotto.domain.Lottos;
import lotto.domain.Seller;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.printInputMoney();
        int countOfLotto = Seller.returnLotto(money);
        OutputView.printLottoCount(countOfLotto);

        LottoCreator lottoCreator = new LottoCreator();
        LottoService lottoService = new LottoService();
        List<Lotto> lottoList = lottoService.createLotto(countOfLotto, lottoCreator);
        Lottos lottos = new Lottos(lottoList);

        OutputView.printLotto(lottos.extractLottoNumbers());

    }

}
