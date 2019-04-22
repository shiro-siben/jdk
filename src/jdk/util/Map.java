package jdk.util;

/**
 * @author: shiro.siben@gmail.com
 * @date: 2019/4/22 11:42
 * @description:
 *  Map 接口中提供了3种集合视图，分别为:
 *                                  1> Map 对象中所有 Key 的集合，
 *                                  2> Map 对象中所有 value 的集合，
 *                                  3> Map 对象中所有实例（entry）的集合
 *  Map 中实例的顺序与 map 对象的迭代器遍历 Map 实例集合的顺序相同;
 *      而在一些 Map 接口的实现中，例如：TreeMap 对于 Map 对象中的实例提供了排序算法，
 *      而 HashMap 则没有提供类似的机制;
 *
 *  与 java.util.Set 接口类似，由于 Map 接口中对于 key 要求的唯一性，最好不要将一个易变对象作为
 *      Map 的 key，因为在修改过程中导致的两个 key 相等的情况，Map 并不能很好的检测到，可能会影响到
 *      map 针对这个 key 的行为。但是我们可以将这个可变对象作为 map 的值存在，因为对象的修改并不会
 *      影响到 map 的其它操作;
 *
 *
 *  在 Map 接口的实现过程中，一般需要提供两个构造方法：
 *                                              1> 默认无参构造方法
 *                                              2> 带有 Map 参数的构造方法
 *     实际上，第二种构造方法的形式允许用户去拷贝任何 map 对象，生成一个等价的、拥有特定类型
 *     的 map 对象。该接口中也定义了一些可选的方法，当被调用的 map 对象不支持这些方法时，将
 *     抛出 UnsupportedOperationException 异常。当用户调用的方法不会对 map 对象产生任何
 *     修改时，也可以选择抛出异常（非强制性抛出）
 *
 *
 *  一些 Map 接口的实现对于 key 和 value 均存在一些限制。如：有些实现不允许将 null 作为 key
 *      或者 value，而有些实现则规定了其合法的 key 和 value 类型。当试图插入一个非法的 key
 *      或者 value 时，则会抛出非检查（unchecked）异常，一般情况下是 NullPointerException
 *      或者 ClassCastException。当检索到一个非法的 key 或者 value 时，则可能会抛出异常或者
 *      返回 false
 *
 *
 *  许多集合框架中的方法均基于 equals 方法实现。例如：containsKey(Object key) 声明：当 map
 *      对象存在一个 key:k 满足条件（key==null ? k=null : key.equals(k)）时，则返回 true，
 *      否则返回 false。但这并不代表调用该方法时，对于一个非空的 key 都一定会调用 key.equals(k)。
 *      在 Map 接口的实现过程中，可以做一定的优化，如：首先判断二者的哈希值是否相等，如果相等，
 *      再调用 equals，否则可以直接返回 false。也就是说在实现集合接口的方法时，可以适当利用底层
 *      Object 提供的方法提升算法效率
 *
 *  Map 定义的基于递归调用的操作在直接自引用或者间接自引用的情况下，可能失败。这些方法包括：
 *      clone(),equals(),hashCode(),toString()。在实现 Map 接口的过程中，可以对自引用进行
 *      校验，但是目前的实现并没有提供这种机制
 *
 *
 *
 *
 *  Map 内部接口说明（Entry）
 *      类说明
 *          Map 中记录实例，每个实例是一个键值对（key-value pair）。当调用方法 Map.entrySet() 时，
 *          则会返回一个 Entry 的集合，调用该集合的迭代器是唯一一个获取 Map 中记录的方式。并且这些
 *          记录（Entry）对象与遍历该集合的迭代器有效期相同，也就是说：当在迭代该元素时，Map 中的记录
 *          发生了结构性修改，那么在修改之前生成的迭代器可能获取到脏数据
 *
 *
 *  方法介绍
 *      K getKey();
 *          返回当前键值对中的键
 *
 *      V getValue();
 *          返回当前键值对中的值，如果该对应关系在调用该方法时，被其它线程使用迭代器的 remove 方法
 *          删除该实例，那么调用该方法可能返回脏数据
 *
 *      V setValue(V value);
 *          将当前实例中的值用指定的值代替（可选操作）。同理，当调用该方法时，被其它线程使用迭代器的
 *          remove 方法删除该实例，那么调用该方法可能返回脏数据
 *
 *      boolean equals(Object o);
 *          判断两条记录是否相等，当两者相等时，返回 true，否则返回 false
 *
 *
 *      int size();
 *          返回当前 Map 对象中包含 key-value 对的数目
 *
 *      boolean isEmpty();
 *          判断当前 Map 对象是否包含 key-value 对，若包含，返回 true，否则返回 false
 *
 *      boolean containsKey(Object key);
 *          当 Map 对象中包含一个与 key 相等的键时，返回 true，否则返回 false。
 *              判断相等的条件是：(key==null ? k==null : key.equals(k)) （在一个 Map 对象中，
 *              至多存在一个满足这个条件的 key ）
 *
 *      boolean containsValue(Object value);
 *          判断当前的 Map 对象是否包含与 value 相等的值，其判定条件为：value==null ? v==null :
 *              value.equals(v)。这个操作在大多数的 Map 实现中，其执行时间与 Map 对象的大小呈
 *              线性关系
 *
 *      V get(Object key);
 *          返回 Map 中键 key 对应的 value 值，当 Map 中不包含 key 时，返回 null（在每个 Map 中，
 *              至多存在一个满足这种条件的值）。如果当前的 Map 对象允许 null 作为值，那么返回的
 *              null 将不能证明对应的 key 在 Map 对象中不存在，可能在 Map 对象中，key 对应的
 *              值就是 null；在这种情况下，可能需要调用 containsKey(Object key) 来区分这两种情况
 *
 *
 *      V put(K key, V value);
 *          在 Map 对象中，创建并保存 key 与 value 的对应关系（可选操作）。如果当前 Map 中已经
 *              存在了一个键为 key 的键值对，则将这个键对应的值用 value 替换。对于一个 Map 对象
 *              m ，并且仅当调用 m.containsKey(k) 返回 true 时，才认为 m 中存在键为 k 的
 *              键值对。当存在该键时，返回对应的旧值，否则返回 null
 *
 *      V remove(Object key);
 *          删除 Map 中键值为 key 的键值对。当 Map 对象中包含 key 时，返回其对应的值，否则返回 null
 *          。当该 Map 允许 null 作为值时，则返回 null 并不一定代表 Map 中不存在键为 key 的键值对。
 *          在调用该方法后，该 Map 对象将不再包含任何一个键为 key 的键值对
 *
 *      void putAll(Map<? extends K, ? extends V> m);
 *          将 m 中所有的键值对复制到当前 Map 对象中。这个方法的执行结果相当于遍历 m 中所有的
 *              键值对 k-v，并对每个键值对调用 put(k,v) 方法。当在执行本方法过程中，m 发生
 *              并发结构修改，则该方法将产生不确定的执行结果
 *
 *      void clear();
 *          删除该 Map 对象中所有的 key-value 对，在调用该方法后，该 Map 对象将不包含任何实例
 *
 *      Set<K> keySet();
 *          将当前 Map 对象中包含的所有的 key 生成一个不包含重复元素的集合 Set。这个集合由当前
 *              Map 对象进行维护，因此对当前 Map 对象进行的操作将会直接反映到该集合中，反之亦然。
 *              如果迭代这个 key 集合时，Map 对象发生了修改（除持有 key 迭代器的线程外），那么
 *              将产生不确定的迭代结果。这个集合允许通过 Iterator.remove,Set.remove,
 *              removeAll,retainAll 和 clear 进行删除元素操作。但是不支持 add 和 addAll 操作
 *
 *      Collection<V> values();
 *          将当前 Map 对象中包含的所有的 value ，生成一个集合（Collection，可能包含重复元素）。
 *              其也由 Map 对象进行维护，其修改操作会互相影响
 *
 *      Set<Map.Entry<K, V>> entrySet();
 *          返回当前 Map 对象中包含的所有 key-value 对，并生成 Map.Entry 的集合
 *
 *      boolean equals(Object o);
 *          判断两个 Map 对象是否相等，因为 Map 对象代表一种对应关系，因此当两个 Map 对象包含
 *              相同的对应关系时，则认为两者相等
 *
 *      int hashCode();
 *          返回当前对象 Map 对象的哈希值，一个 Map 对象的哈希值是当前对象中包含的所有的哈希值的总和
 *
 *
 *
 *
 *
 *
 */
public interface Map<k,v> {

}
