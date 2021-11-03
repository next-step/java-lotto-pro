package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPaperList {

    private List<LottoPaper> lottoPaperList = new ArrayList<LottoPaper>();

    public LottoPaperList(List<LottoPaper> lottoPaperList) {
        this.lottoPaperList = lottoPaperList;
    }

    public List<LottoPaper> getLottoPaperList() {
        return lottoPaperList;
    }
}
