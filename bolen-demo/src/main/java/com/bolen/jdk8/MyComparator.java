/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.bolen.jdk8;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


/**
 * A comparison function, which imposes a <i>total ordering</i> on some
 * collection of objects. Comparators can be passed to a sort method (such as
 * {@link Collections#sort(List,MyComparator) Collections.sort} or
 * {@link Arrays#sort(Object[],MyComparator) Arrays.sort}) to allow precise
 * control over the sort order. Comparators can also be used to control the
 * order of certain data structures (such as {@link SortedSet sorted sets} or
 * {@link SortedMap sorted maps}), or to provide an ordering for collections of
 * objects that don't have a {@link Comparable natural ordering}.
 * <p>
 *
 * The ordering imposed by a comparator <tt>c</tt> on a set of elements
 * <tt>S</tt> is said to be <i>consistent with equals</i> if and only if
 * <tt>c.compare(e1, e2)==0</tt> has the same boolean value as
 * <tt>e1.equals(e2)</tt> for every <tt>e1</tt> and <tt>e2</tt> in <tt>S</tt>.
 * <p>
 *
 * Caution should be exercised when using a comparator capable of imposing an
 * ordering inconsistent with equals to order a sorted set (or sorted map).
 * Suppose a sorted set (or sorted map) with an explicit comparator <tt>c</tt>
 * is used with elements (or keys) drawn from a set <tt>S</tt>. If the ordering
 * imposed by <tt>c</tt> on <tt>S</tt> is inconsistent with equals, the sorted
 * set (or sorted map) will behave "strangely." In particular the sorted set (or
 * sorted map) will violate the general contract for set (or map), which is
 * defined in terms of <tt>equals</tt>.
 * <p>
 *
 * For example, suppose one adds two elements {@code a} and {@code b} such that
 * {@code (a.equals(b) && c.compare(a, b) != 0)} to an empty {@code TreeSet}
 * with comparator {@code c}. The second {@code add} operation will return true
 * (and the size of the tree set will increase) because {@code a} and {@code b}
 * are not equivalent from the tree set's perspective, even though this is
 * contrary to the specification of the {@link Set#add Set.add} method.
 * <p>
 *
 * Note: It is generally a good idea for comparators to also implement
 * <tt>java.io.Serializable</tt>, as they may be used as ordering methods in
 * serializable data structures (like {@link TreeSet}, {@link TreeMap}). In
 * order for the data structure to serialize successfully, the comparator (if
 * provided) must implement <tt>Serializable</tt>.
 * <p>
 *
 * For the mathematically inclined, the <i>relation</i> that defines the
 * <i>imposed ordering</i> that a given comparator <tt>c</tt> imposes on a given
 * set of objects <tt>S</tt> is:
 * 
 * <pre>
 *       {(x, y) such that c.compare(x, y) &lt;= 0}.
 * </pre>
 * 
 * The <i>quotient</i> for this total order is:
 * 
 * <pre>
 *       {(x, y) such that c.compare(x, y) == 0}.
 * </pre>
 *
 * It follows immediately from the contract for <tt>compare</tt> that the
 * quotient is an <i>equivalence relation</i> on <tt>S</tt>, and that the
 * imposed ordering is a <i>total order</i> on <tt>S</tt>. When we say that the
 * ordering imposed by <tt>c</tt> on <tt>S</tt> is <i>consistent with
 * equals</i>, we mean that the quotient for the ordering is the equivalence
 * relation defined by the objects' {@link Object#equals(Object) equals(Object)}
 * method(s):
 * 
 * <pre>
 *     {(x, y) such that x.equals(y)}.
 * </pre>
 *
 * <p>
 * Unlike {@code Comparable}, a comparator may optionally permit comparison of
 * null arguments, while maintaining the requirements for an equivalence
 * relation.
 *
 * <p>
 * This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html"> Java
 * Collections Framework</a>.
 *
 * @param <T> the type of objects that may be compared by this comparator
 *
 * @author Josh Bloch
 * @author Neal Gafter
 * @see Comparable
 * @see java.io.Serializable
 * @since 1.2
 */
@FunctionalInterface
public interface MyComparator<T> {
	
	int compare(T o1, T o2);

	
	boolean equals(Object obj);
	
	String toString();
	//public void test();
	
}
