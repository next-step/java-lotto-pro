package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumbersFactory;
import lotto.domain.LottoReports;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Lotto {
    public void start() {
        LottoMoney lottoMoney = InputView.inputLottoAmount();
        List<LottoTicket> lottoTickets = buyLottoTicket(lottoMoney.countOfPossibleLotto());
        OutputView.printLottoTickets(lottoTickets);
        LottoTicket winningLottoTicket = InputView.winningNumbersOfLastWeek();
        LottoReports lottoReports = new LottoReports(createRanks(lottoTickets, winningLottoTicket), lottoMoney);
        OutputView.printLottoReports(lottoReports);
    }

    private List<LottoTicket> buyLottoTicket(int countOfPossibleLotto) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < countOfPossibleLotto; i++) {
            lottoTickets.add(new LottoTicket(LottoNumbersFactory.createLottoNumbers()));
        }
        return lottoTickets;
    }

    private List<Rank> createRanks(List<LottoTicket> lottoTickets, LottoTicket winningLottoTicket) {
        List<Rank> ranks = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            ranks.add(lottoTicket.winningRank(winningLottoTicket));
        }
        return ranks;
    }
}
