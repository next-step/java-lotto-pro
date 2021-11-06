package lotto.service;

import lotto.domain.*;
import lotto.exception.InputDataErrorCode;
import lotto.exception.InputDataException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    private WinningLotto winningLotto;

    public Lottos createLotto(int countOfLotto) {
        List<Lotto> lottoBasket = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            List<Ball> balls = makeBall(LottoCreator.makeLotto());
            lottoBasket.add(new Lotto(balls));
        }
        return new Lottos(lottoBasket);
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

    public WinningLotto winningLotto() {
        return this.winningLotto;
    }

    private List<Ball> makeBall(List<Integer> lottoNumbers) {
        List<Ball> balls = new ArrayList<>();
        for (Integer lottoNumber : lottoNumbers) {
            balls.add(new Ball(lottoNumber));
        }
        return balls;
    }
}
