package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBag {

    private final List<Lotto> lottoList;

    public static final Money LOTTO_PRICE = new Money(1000);

    public LottoBag(Money money) {
        lottoList = new ArrayList<>();
        while (money.isEqualsOrGreater(LOTTO_PRICE)) {
            money.minus(LOTTO_PRICE);
            lottoList.add(new Lotto());
        }
    }

    public List<WinningResult> getResult(List<Integer> winningNumbers) {
        return lottoList.stream()
                .map(lotto -> lotto.getResult(winningNumbers))
                .collect(Collectors.toList());
    }

    public long hasSize() {
        // 캡슐화하여 내부로 은닉한 lottoList의 갯수를 테스트에서 비교하기 위해 생성한 메서드
        // 테스트를 위한 메서드 생성이 허용 되어야 한다면, 허용 기준이 무엇일까..?
        return lottoList.size();
    }
}
