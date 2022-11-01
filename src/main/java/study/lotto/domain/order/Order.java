package study.lotto.domain.order;

import study.lotto.domain.Lotto;

import java.util.List;

public interface Order {
    List<Lotto> order(UserPurchase userPurchase);
}
