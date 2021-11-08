package lotto.service;

import lotto.domain.*;
import lotto.exception.InputDataErrorCode;
import lotto.exception.InputDataException;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    private WinningLotto winningLotto;

    public Lottos createAutoLotto(int countOfLotto) {
        List<Lotto> lottoBasket = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            List<Ball> balls = makeBall(LottoCreator.makeLotto());
            lottoBasket.add(new Lotto(balls));
        }
        return new Lottos(lottoBasket);
    }

    public Lottos createManualLotto(int manualLottoCount, int countOfAutoLotto) {
        List<Lotto> manualLottos = new ArrayList<>();

        validInputLottoCount(manualLottoCount, countOfAutoLotto);
        if (manualLottoCount > 0) {
            InputView.printInputManualLotto();
        }
        while (manualLottoCount-- > 0) {
            List<Integer> inputManualLottoNumbers = InputView.inputManualLotto();
            List<Ball> manualBalls = makeBall(inputManualLottoNumbers);
            Lotto manualLotto = new Lotto(manualBalls);
            manualLottos.add(manualLotto);
        }
        return new Lottos(manualLottos);
    }

    private void validInputLottoCount(int manualLottoCount, int countOfAutoLotto) {
        if (manualLottoCount > countOfAutoLotto) {
            throw new InputDataException(InputDataErrorCode.INPUT_MANUAL_LOTTO_COUNT_MAXED_OUT_MY_MONEY);
        }
    }

    public Map<Rank, Integer> result(Lottos lottos) {
        Map<Rank, Integer> lottoResult = new HashMap<Rank, Integer>();
        for (Lotto lotto : lottos) {
            Rank findRank = this.match(lotto);
            Integer rankCount = lottoResult.getOrDefault(findRank, 0);
            lottoResult.put(findRank, rankCount + 1);
        }
        return lottoResult;
    }

    public Rank match(Lotto lotto) {
        return Rank.rank(winningLotto.match(lotto), winningLotto.isMatchBonusBall(lotto));
    }

    public void makeWinningLotto(List<Integer> winningLottoNumbers, int bonusBallNumber) {
        List<Ball> winningBalls = winningLottoNumbers.stream()
                .map(number -> new Ball(number))
                .collect(Collectors.toList());
        Lotto changedLotto = new Lotto(winningBalls);
        Ball bonusBall = new Ball(bonusBallNumber);
        this.winningLotto = new WinningLotto(changedLotto, bonusBall);
    }

    public List<Ball> makeBall(List<Integer> lottoNumbers) {
        List<Ball> balls = new ArrayList<>();
        for (Integer lottoNumber : lottoNumbers) {
            balls.add(new Ball(lottoNumber));
        }
        return balls;
    }

    public WinningLotto winningLotto() {
        return this.winningLotto;
    }
}
