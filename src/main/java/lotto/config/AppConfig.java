package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.repository.LottoNumbersRepository;
import lotto.domain.repository.LottoNumbersRepositoryImpl;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.LottoRepositoryImpl;
import lotto.domain.repository.PurchaseRepository;
import lotto.domain.repository.PurchaseRepositoryImpl;
import lotto.domain.service.LottoService;
import lotto.domain.service.LottoServiceImpl;
import lotto.view.LottoConsoleView;
import lotto.view.LottoView;

public abstract class AppConfig {

    public static LottoController lottoController() {
        return new LottoController(lottoService(), lottoView());
    }

    private static LottoView lottoView() {
        return new LottoConsoleView();
    }

    private static LottoService lottoService() {
        return new LottoServiceImpl(purchaseRepository(), lottoNumbersRepository(), lottoRepository());
    }

    private static LottoNumbersRepository lottoNumbersRepository() {
        return new LottoNumbersRepositoryImpl();
    }

    private static LottoRepository lottoRepository() {
        return new LottoRepositoryImpl();
    }

    private static PurchaseRepository purchaseRepository() {
        return new PurchaseRepositoryImpl();
    }
}
