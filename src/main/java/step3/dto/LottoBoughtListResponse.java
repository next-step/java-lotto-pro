package step3.dto;

import java.util.ArrayList;
import java.util.List;

import step3.domain.LottoNumbersBundle;

public class LottoBoughtListResponse {
    private final LottoNumbersBundle manualLottoList;
    private final LottoNumbersBundle autoLottoList;

    public LottoBoughtListResponse(LottoNumbersBundle manualLottoList,
        LottoNumbersBundle autoLottoList) {
        this.manualLottoList = manualLottoList;
        this.autoLottoList = autoLottoList;
    }

    public List<String> getManualLottoList() {
        List<String> result = new ArrayList<>();
        result.addAll(manualLottoList.getResult());
        result.addAll(autoLottoList.getResult());
        return result;
    }

    public LottoNumbersBundle getAutoLottoList() {
        return autoLottoList;
    }

    public int getManualSize() {
        return manualLottoList.size();
    }

    public int getAutoSize() {
        return autoLottoList.size();
    }
}
