package lotto.service;

import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    private Lotto winningLotto;

    public List<Lotto> createLotto(int countOfLotto, LottoCreator lottoCreator) {
        List<Lotto> lottoBasket = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            List<Ball> balls = makeBall(lottoCreator.makeLotto());
            lottoBasket.add(new Lotto(balls));
        }
        return lottoBasket;
    }

    public void makeWinningLotto(List<Integer> winningLottoNumber) {
        List<Ball> winningBalls = winningLottoNumber.stream()
                .map(number -> new Ball(number))
                .collect(Collectors.toList());
        this.winningLotto = new Lotto(winningBalls);
    }

    public Rank match(Lotto lotto) {
        return Rank.rank(winningLotto.match(lotto));
    }

    public Map<Rank, Integer> result(Lottos lottos) {
        Map<Rank, Integer> lottoResult = new HashMap<Rank,Integer>();
        for (Lotto lotto : lottos) {
            Rank findRank = this.match(lotto);
            Integer rankCount = lottoResult.getOrDefault(findRank, 0);
            lottoResult.put(findRank, rankCount + 1);
        }
        return lottoResult;
    }

    public Lotto winningLotto() {
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
