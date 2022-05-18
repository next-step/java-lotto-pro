package study.lotto.domain.draw;

import static study.lotto.domain.draw.Division.DIVISION_NONE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivisionRule {
    private final Map<Boolean, List<Division>> values;

    public DivisionRule() {
        this.values = new HashMap<>();
    }

    public int hasSize() {
        return values.values().stream()
                .map(List::size)
                .reduce(0, (size1, size2) -> size1 + size2);
    }

    public void add(Division division, Boolean matchBonus) {
        if (!values.containsKey(matchBonus)) {
            values.put(matchBonus, new ArrayList<>());
        }
        addElement(division, matchBonus);
    }

    public Division check(int matchCount, boolean matchBonus) {
        return values.get(matchBonus).stream()
                .filter(division -> division.hasSameMatchCount(matchCount))
                .findFirst()
                .orElse(DIVISION_NONE);
    }

    private void addElement(Division division, Boolean matchBonus) {
        List<Division> divisions = values.get(matchBonus);
        divisions.add(division);
    }
}
