package step3.domain;

import java.util.Map;

@FunctionalInterface
public interface CriteriaProvider {

    Map<Integer, Long> get();
}
