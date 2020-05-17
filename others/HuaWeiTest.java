package others;

import java.util.Scanner;

/**
 * 牛客网华为测试题目，需要使用 Scanner 从标准输入读取 input 数据
 * 题目描述
 * 描述：
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * 输入描述:
 * 输入一个int整数
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 1516000
 * 输出
 * 0006151
 * @author masikkk.com 2020-05-17 20:57
 */
public class HuaWeiTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        while (input > 0) {
            sb.append(input % 10);
            input /= 10;
        }
        System.out.println(sb.toString());
    }
}