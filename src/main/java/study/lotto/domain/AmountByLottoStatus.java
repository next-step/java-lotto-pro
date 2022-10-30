package study.lotto.domain;

import study.util.NumberUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AmountByLottoStatus {

    private final Map<LottoStatus, Long> amountByLottoStatus = new HashMap<>();

    public AmountByLottoStatus() {
        initTotalAmountMap();
    }

    private void initTotalAmountMap() {
        Arrays.stream(LottoStatus.values())
            .forEach((status) -> {
                amountByLottoStatus.put(status, NumberUtil.INIT_ZERO_LONG);
            });
    }

    public void accumulate(LottoStatus status) {
        amountByLottoStatus.replace(status,
                status.accumlateByLottoStatus(amountByLottoStatus.get(status))
        );
    }

    public long sumTotalAmount() {
        return amountByLottoStatus.entrySet().stream()
                .mapToLong(Map.Entry::getValue)
                .sum();
    }

    public Map<LottoStatus, Long> countsByLottoStatus() {
        Map<LottoStatus, Long> countsByLottoStatus = new HashMap<>();

        amountByLottoStatus.keySet().forEach((status) -> {
            countsByLottoStatus.put(status, countByLottoStatus(status));
        });

        return countsByLottoStatus;
    }

    private long countByLottoStatus(LottoStatus status) {
        return status.countByLottoStatus(amountByLottoStatus.get(status));
    }
}
