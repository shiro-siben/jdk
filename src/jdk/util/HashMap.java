package jdk.util;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;


/**
 * 哈希表（hash table）也叫散列表，是一种非常重要的数据结构，应用场景及其丰富，许多缓存技术（比如
 *   memcached）的核心其实就是在内存中维护一张大的哈希表
 *
 * 什么是哈希表？
 *      在讨论哈希表之前，我们先了解一下其它数据结构在新增，查找等基础操作方面的执行性能
 *    数据结构：
 *      1> 数组：采用一段连续的存储单元来存储数据。对于指定下标的查找，时间复杂度为 O(1)；
 *              通过给定值进行查找，需要遍历数组，逐一对比给定关键字和数组元素，时间复杂度为 O(n),
 *              当然，对于有序数组，则可采用二分查找，插值查找，斐波那契查找等方式，可将
 *              查找复杂度提高为 O(logn)；对于一般的插入删除操作，涉及到数组元素的移动，
 *              其平均复杂度也是 O(n)
 *      2> 线性链表：对于链表的新增，删除等操作（在找到指定操作位置后），仅需要处理节点间的引用即可，
 *          时间复杂度为 O(1)，而查找操作需要遍历链表逐一进行比对，复杂度为 O(n)
 *      3> 二叉树：对一棵相对平衡的有序二叉树，对其进行插入，查找，删除等操作，平均复杂度为 O(logn)
 *      4> 哈希表：相比上述几种数据结构，在哈希表中进行添加，删除，查找等操作，性能十分之高，不考虑
 *          哈希冲突的情况下，仅需一次定位即可完成，时间复杂度为 O(1).
 *
 *
 */

/**
 * @author: shiro.siben@gmail.com
 * @date: 2019/4/22 17:40
 * @description:
 */
public class HashMap extends AbstractMap<K, V> implements Map<K, V>,
    Cloneable, Serializable {

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }
}
