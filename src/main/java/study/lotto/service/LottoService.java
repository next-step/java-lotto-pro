package study.lotto.service;

import study.lotto.domain.*;

import java.util.Map;


public class LottoService {

    private final OrderService orderService;

    public LottoService(OrderService orderService) {
        this.orderService = orderService;
    }

    private Lottos lottos;
    private WinningLotto winningLotto;
    private WinStats winStats;

    public void createLottos() {
        this.lottos = Store.buyLottos(orderService.findOne());
    }

    public String countByOrderType() {
        return lottos.countByOrderType();
    }

    public String getPrintedLottos() {
        return lottos.toString();
    }

    public void createWinningLotto(String winningLotto) {
        this.winningLotto = new WinningLotto(winningLotto);
    }

    public void addBonusBall(int bonusBall) {
        winningLotto.addBonusBall(bonusBall);
    }

    public void drawLots() {
        this.winStats = lottos.drawLots(winningLotto);
    }

    public Map<LottoStatus, Long> getPrintDataWithCountsByLottoStatus() {
        return winStats.countsByLottoStatus();
    }

    public String getPrintDataWithProfitRate() {
        return winStats.getProfitRate();
    }
}
