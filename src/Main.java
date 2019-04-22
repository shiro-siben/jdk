public class Main {
    /**
     * @author: shiro.siben@gmail.com
     * @date: 2019/4/22 11:19
     * @param:
     * @return:
     * @description: 获取 map 中的所有元素
     */
    public static void main(String[] args) {

        /**
         * map 中是没有迭代器的，collection 具备迭代器，只要将 map 集合转成 Set 集合，就可以使用
         * 迭代器了，之所以转成 Set，是因为 map 集合具备着键的唯一性，其实 Set 集合就来自于 map，
         * Set 集合底层其实用的就是 map 的方法
         */

        /**
         * 把 map 集合转成 Set 的方法：
         * 主要通过 Set KetSet() 和 SMet entrySet(); // 取得是键和值的映射关系
         * Entry 是 Map 接口中的内部接口
         * 为什么要定义在 Map 内部呢？entry 是访问键值关系的入口，是 Map 的入口，访问的是 Map 中的键值对
         */


        System.out.println("Hello World!");
    }
}
