package com.home;

/**
 * The Predicate
 */
public interface Predicate<T> {

    /**
     * The test method
     */
	boolean test(T t);
}
