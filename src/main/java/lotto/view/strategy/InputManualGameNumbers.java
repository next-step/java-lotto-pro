package lotto.view.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputManualGameNumbers extends InputLottoNumbers implements InputMultiLine {

    private static final String MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    /**
     * 멀티라인 입력값 반환
     *
     * @param rowCount
     * @return
     */
    @Override
    public List<String> getMultiValues(int rowCount) {
        final int firstIndex = 0;
        return IntStream.range(firstIndex, rowCount)
                .boxed()
                .map(index -> this.getValue(index == firstIndex))
                .collect(Collectors.toList());
    }

}
