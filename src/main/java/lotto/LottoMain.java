package lotto;

import com.sun.tools.internal.ws.wsdl.document.Output;
import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMain {
    private static final LottoCreator lottoCreator = new LottoCreator();
    private static final LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        int money = InputView.printInputMoney();
        int countOfLotto = Seller.returnLotto(money);
        OutputView.printLottoCount(countOfLotto);

        List<Lotto> lottoList = lottoService.createLotto(countOfLotto, lottoCreator);
        Lottos lottos = new Lottos(lottoList);
        OutputView.printLotto(lottos.extractLottoNumbers());

        List<Integer> winningLottoNumber = InputView.printInputWinningLotto();

        lottoService.makeWinningLotto(winningLottoNumber);




    }

}
