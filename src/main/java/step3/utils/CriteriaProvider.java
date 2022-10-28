package step3.utils;

import java.util.Map;

@FunctionalInterface
public interface CriteriaProvider {

    Map<Integer, Long> get();
}
