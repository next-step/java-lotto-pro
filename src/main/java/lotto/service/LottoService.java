package lotto.service;

import lotto.domain.Ball;
import lotto.domain.Lotto;
import lotto.domain.LottoCreator;

import java.util.ArrayList;
import java.util.List;
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

    public void makeWinningLotto(List<Integer> winningLottoNumber){
        List<Ball> winningBalls = winningLottoNumber.stream()
                .map(number -> new Ball(number))
                .collect(Collectors.toList());
        this.winningLotto = new Lotto(winningBalls);
    }

    public Lotto winningLotto(){
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
