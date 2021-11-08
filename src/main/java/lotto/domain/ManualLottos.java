package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottos {

    private final List<Lotto> manualLottos;

    public ManualLottos(List<String> manualNumbers) {
        this.manualLottos = manualNumbers.stream()
                .map(numbers -> new Lotto(numbers))
                .collect(Collectors.toList());
    }

    public List<Lotto> getManualLottos() {
        return Collections.unmodifiableList(manualLottos);
    }
}
