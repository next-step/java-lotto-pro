package model;

@FunctionalInterface
interface MatchCondition {

	boolean match(int matchCount, boolean isMatchedBonus);

}
