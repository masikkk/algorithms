# 算法题
博客 LeetCode 标签：

http://masikkk.com/tags/LeetCode/

# 项目结构
2020.4.2 为项目增加 maven 支持，引入 junit5 测试框架

clone 后用 IDEA 打开，进行如下设置：

File -> Project Structure -> Modules

把根目录 `.` 设为 Test Source Folders

目录 `leetcode` 中是 LeetCode 上的题目，目录中再分为3个子目录(Java包): 
- `leetcode` LeetCode 自有题目
- `offer` 《剑指offer》题目
- `crack` 《程序员面试金典（第 6 版）》题目

题目类名以 `_编号_题目英文名` 命名，方便自动按文件名排序，类中以 **年份结尾的私有静态内部类** `private static class SolutionV2020` 命名各个年份写的 `Solution` 类，以便于一个题目可以多次做，每次的解法能互相独立保存。

目录 `structs` 中是链表、二叉树等公用数据结构，操作这些数据结构的 `static` 方法（例如数组转链表、字符串转数组、字符串转二叉树等）放到数据结构本身的 class 中，避免每个二叉树题目中都重新定义一遍数据结构类。

目录 `others` 中是面试过程中，或者其他地方看到的题目

