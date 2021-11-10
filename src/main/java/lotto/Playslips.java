package lotto;

import java.util.ArrayList;
import java.util.List;

public class Playslips {

    private final List<Playslip> playslips;

    public Playslips(List<Playslip> playslips) {
        this.playslips = new ArrayList<>(playslips);
    }

    public int getSize() {
        return playslips.size();
    }
}
