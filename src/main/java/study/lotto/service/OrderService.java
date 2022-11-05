package study.lotto.service;

import study.lotto.domain.order.Order;

public class OrderService {

    private Order order;

    public void createOrder(String amount) {
        order = new Order(amount);
    }

    public void addManualQuantity(int quantity) {
        order.addManualQuantity(quantity);
    }

    public boolean canOrderManualLotto() {
        return order.canOrderManualLotto();
    }

    public void addManualLotto(String lotto) {
        order.addManualLotto(lotto);
    }

    Order findOne() {
        return order;
    }

}
