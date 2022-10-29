package lotto.domain.service;

import lotto.domain.Lotto;
import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.lottonumber.purchase.Purchase;
import lotto.domain.repository.LottoNumbersRepository;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.PurchaseRepository;
import lotto.domain.result.DefaultLottoResult;

public class LottoServiceImpl implements LottoService {

    private final PurchaseRepository purchaseRepository;
    private final LottoNumbersRepository lottoNumbersRepository;
    private final LottoRepository lottoRepository;

    public LottoServiceImpl(PurchaseRepository purchaseRepository,
                            LottoNumbersRepository lottoNumbersRepository,
                            LottoRepository lottoRepository) {
        this.purchaseRepository = purchaseRepository;
        this.lottoNumbersRepository = lottoNumbersRepository;
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void savePurchase(String purchase) {
        purchaseRepository.save(new Purchase(purchase));
    }

    @Override
    public void saveLottoNumbers() {
        lottoNumbersRepository.save(new LottoNumbers(purchaseRepository.findOne()));
    }

    @Override
    public LottoNumbers findLottoNumbers() {
        return lottoNumbersRepository.findOne();
    }

    @Override
    public void saveLotto(String readWinningNumber) {
        lottoRepository.save(new Lotto(findLottoNumbers(), readWinningNumber));
    }

    @Override
    public DefaultLottoResult result() {
        return lottoRepository.findOne().result();
    }

    @Override
    public String makeProfitMargin() {
        return lottoRepository.findOne().makeProfitMargin(purchaseRepository.findOne());
    }
}
