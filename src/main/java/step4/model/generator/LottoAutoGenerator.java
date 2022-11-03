package step4.model.generator;

import step4.constant.LottoConstant;
import step4.model.Lotto;
import step4.model.LottoBuyCount;
import step4.model.LottoNumber;
import step4.model.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator implements LottoGenerator {

    private static final List<LottoNumber> lottoCandidateNumbers;
    private final LottoBuyCount lottoBuyCount;

    static {
        lottoCandidateNumbers = IntStream.rangeClosed(LottoConstant.LOTTO_MIN_NUM, LottoConstant.LOTTO_MAX_NUM)
                .mapToObj(LottoNumber::of).collect(Collectors.toList());
    }

    public LottoAutoGenerator(int lottoBuyCount) {
        this(new LottoBuyCount(lottoBuyCount));
    }

    public LottoAutoGenerator(LottoBuyCount lottoBuyCount) {
        this.lottoBuyCount = lottoBuyCount;
    }

    private Lotto createLotto() {
        Collections.shuffle(lottoCandidateNumbers);
        return new Lotto(
                new ArrayList<>(lottoCandidateNumbers.subList(0, LottoConstant.PICK_LOTTO_MAX_NUM))
        );
    }

    @Override
    public Lottos createLottos() {
        ArrayList<Lotto> lottos = new ArrayList<>();
        LottoBuyCount index = new LottoBuyCount(0);
        while (index.isLessThan(lottoBuyCount)) {
            lottos.add(createLotto());
            index.plus();
        }
        return new Lottos(lottos);
    }
}
