package lotto.domain.repository;

import lotto.domain.lottonumber.purchase.Purchase;

public class PurchaseRepositoryImpl implements PurchaseRepository {

    private Purchase purchase;

    @Override
    public void save(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public Purchase findOne() {
        return purchase;
    }
}
