# 算法题
博客 LeetCode 标签：

http://masikkk.com/tags/LeetCode/

# 项目结构
1、目录 `leetcode` 中是 [LeetCode](https://leetcode-cn.com/) 上的题目，目录中再分为3个子目录(Java包): 
- `leetcode` LeetCode 自有题目
- `offer` 《剑指offer》题目
- `crack` 《程序员面试金典（第 6 版）》题目

2、题目 class 类名以 `_编号_题目英文名` 命名，方便自动按文件名排序，类中以 **年份结尾的私有静态内部类** `private static class SolutionV2020` 命名各个年份写的 `Solution` 类，以便于一个题目可以多次做，多次的解法能在同一个题目类中共存。

3、目录 `structs` 中是链表、二叉树等公用数据结构，操作这些数据结构的 `static` 方法（例如数组转链表、字符串转数组、字符串转二叉树等）放到数据结构本身的 class 中，避免每个二叉树题目中都重新定义一遍数据结构类。

4、目录 `utils` 中是工具类

5、目录 `others` 中是面试过程中，或者其他地方看到的题目

6、目录 `sort` 是排序算法练手。

7、目录 `temp` 中是没做完的题目，或者做完还没来得及写博客总结的。

8、2020.4.2 为项目增加 maven 支持，增加 pom.xml 文件，引入 JUnit5 测试框架

# IDEA 项目配置
clone 后用 IDEA 打开，进行如下设置：

File -> Project Structure -> Modules

需要把根目录 `.` 设为 Test Source Folders ，即根目录就是测试源码目录，否则找不到 `@Test` 等 JUnit 中的类。

