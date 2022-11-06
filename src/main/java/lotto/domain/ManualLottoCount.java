package lotto.domain;

import java.util.regex.Pattern;

public class ManualLottoCount {

    public static final String ONLY_NUMBER_REGEX = "^\\d*$";
    private int count;
    private ManualLottoCount(){}

    public static ManualLottoCount create(String input, int totalCount) {
        ManualLottoCount manualLottoCount = new ManualLottoCount();
        manualLottoCount.validateOnlyNumber(input);

        int count = validateCount(input, totalCount);
        manualLottoCount.count = count;

        return manualLottoCount;
    }

    private static int validateCount(String input, int totalCount) {
        int count = Integer.parseInt(input);
        if(totalCount < count){
            throw new IllegalArgumentException("총 로또 구매 갯수보다 클 수 없습니다.");
        }
        return count;
    }

    private void validateOnlyNumber(String input) {
        if(!Pattern.matches(ONLY_NUMBER_REGEX, input)){
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
