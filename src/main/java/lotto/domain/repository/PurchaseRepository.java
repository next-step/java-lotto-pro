package lotto.domain.repository;

import lotto.domain.lottonumber.purchase.Purchase;

public interface PurchaseRepository {

    void save(Purchase purchase);

    Purchase findOne();
}
