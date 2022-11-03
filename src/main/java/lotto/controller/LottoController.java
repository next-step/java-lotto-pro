package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final LottoView view;
    private final LottoUserInput input;
    private final LottoStore lottoStore;

    public LottoController(LottoView view, LottoUserInput input, LottoStore lottoStore) {
        this.view = view;
        this.input = input;
        this.lottoStore = lottoStore;
    }

    public void start() {
        Money paidMoney = getPaidMoney();
        Integer manualLottoTicketCount = getManualLottoCount();
        LottoBundle manualLottoBundle = getManualLottoBundle(manualLottoTicketCount);
        LottoBundle autoLottoBundle = lottoStore.buyAutoLotto(paidMoney, manualLottoTicketCount);
        showLottoBundle(manualLottoBundle,autoLottoBundle);
        LottoBundle allLotto = LottoBundle.merge(manualLottoBundle,autoLottoBundle);
        WinningMoney winningMoney = allLotto.countWinning(getWinningLotto());
        showResult(paidMoney, winningMoney);
    }

    private LottoBundle getManualLottoBundle(Integer manualLottoCount) {
        view.showRequestManualLottoList();
        return new LottoBundle(getManualLottoFromUser(manualLottoCount));
    }

    private List<Lotto> getManualLottoFromUser(Integer manualLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int count = 0; count < manualLottoCount; count++) {
            List<Integer> lottoNumbers = input.getLottoNumbers();
            lottoList.add(new Lotto(lottoNumbers));
        }
        return lottoList;
    }

    private Integer getManualLottoCount() {
        view.showRequestManualLottoCount();
        return input.getPositiveInteger();
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = getWinningLottoNumbers();
        Integer bonusNumber = getBonusNumber();
        return new WinningLotto(winningNumbers, LottoNumber.of(bonusNumber));
    }

    private Integer getBonusNumber() {
        view.showMessageRequestBonusNumber();
        return input.getPositiveInteger();
    }

    private void showLottoBundle(LottoBundle manualBundle,LottoBundle autoBundle) {
        view.showLottoCount(manualBundle.size(), autoBundle.size());
        view.showLotto(manualBundle.toString());
        view.showLotto(autoBundle.toString());
    }

    private Money getPaidMoney() {
        view.showMessageRequestPurchaseMoney();
        return Money.of((input.getPositiveInteger()));
    }

    private List<Integer> getWinningLottoNumbers() {
        view.showMessageRequestWinningNumbers();
        return input.getLottoNumbers();
    }

    private void showResult(Money paidMoney, WinningMoney winningMoney) {
        view.showMessageStatistics();
        showEachRankResult(winningMoney);
        view.showYield(winningMoney.calcYield(paidMoney));
    }

    private void showEachRankResult(WinningMoney winningMoney) {
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.FAIL))
                .forEach(rank -> view.showStatistics(rank, winningMoney.count(rank)));
    }
}
