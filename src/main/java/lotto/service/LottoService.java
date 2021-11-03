package lotto.service;

import lotto.domain.Ball;
import lotto.domain.Lotto;
import lotto.domain.LottoCreator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> createLotto(int countOfLotto, LottoCreator lottoCreator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            List<Ball> balls = makeBall(lottoCreator.makeLotto());
            lottos.add(new Lotto(balls));
        }
        return lottos;
    }

    private List<Ball> makeBall(List<Integer> lottoNumbers) {
        List<Ball> balls = new ArrayList<>();
        for (Integer lottoNumber : lottoNumbers) {
            balls.add(new Ball(lottoNumber));
        }
        return balls;
    }

}
