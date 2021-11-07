package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoReports;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketFactory;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Lotto {
    public void start() {
        LottoMoney lottoMoney = InputView.inputLottoAmount();
        List<LottoTicket> lottoTickets = buyLottoTicket(lottoMoney.getCountOfPossibleLotto());
        OutputView.printLottoTickets(lottoTickets);
        LottoTicket winningLottoTicket = InputView.winningNumbersOfLastWeek();
        LottoNumber bonusNumber = InputView.inputBonusNumber(winningLottoTicket);
        LottoReports lottoReports = new LottoReports(createRanks(lottoTickets, winningLottoTicket, bonusNumber),
            lottoMoney);
        OutputView.printLottoReports(lottoReports);
    }

    private List<LottoTicket> buyLottoTicket(int countOfPossibleLotto) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < countOfPossibleLotto; i++) {
            lottoTickets.add(LottoTicketFactory.createLottoTicket());
        }
        return lottoTickets;
    }

    private List<Rank> createRanks(List<LottoTicket> lottoTickets, LottoTicket winningLottoTicket,
        LottoNumber bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            ranks.add(lottoTicket.createWinningRank(winningLottoTicket, bonusNumber));
        }
        return ranks;
    }
}
