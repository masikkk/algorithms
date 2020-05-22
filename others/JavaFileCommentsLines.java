package others;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 百度一面
 * 给定一个路径，统计路径下所有java文件中注释的行数总和
 * follow ups:
 * 1、要加快统计速度，怎么做？多线程并发处理
 * 2、多线程的话以 目录为单位，还是 以文件为单位？文件，因为能提高并发度
 * 3、假如以目录为单位多线程统计？有的目录下文件很多，有的很少，怎么解决？forkjoin 计算框架，任务窃取
 * @author masikkk.com 2020-05-21 19:46
 */
public class JavaFileCommentsLines {
    Map<String, Integer> fileMd5ToCountMap;
    public int getCommentsLines(String path) throws Exception {
        if (null == path || path.length() < 1) {
           return 0;
        }
        fileMd5ToCountMap = new HashMap<>();
        File dir = new File(path);
        int count = 0;
        // 应该写成递归的
        if (dir != null && dir.isDirectory()) {
            File[] files = dir.listFiles((d, fname) -> fname.endsWith(".java"));
            for (File file : files) {
                count += getCommentsLinesFromFile(file);
            }
        }
        return count;
    }

    /**
     * 统计 file 的注释行数
     * @param file
     * @return
     */
    public int getCommentsLinesFromFile(File file) {
        if (fileMd5ToCountMap.containsKey(file.getName())) {
            return fileMd5ToCountMap.get(file.getName());
        }
        int count = 0;
        boolean inBlockComment = false;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null) {
                if (inBlockComment) {
                    // 在块注释内
                    count++;
                    if (lineStr.contains("*/")) {
                        // 块注释结束
                        inBlockComment = false;
                    }
                    continue;
                }
                if (lineStr.trim().startsWith("//")) {
                    // 注意，必须trim后开头是以 "//" 开头的才是注释行
                    count++;
                } else if (lineStr.contains("/*")) {
                    // 进入块注释
                    count++;
                    inBlockComment = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        JavaFileCommentsLines javaFileCommentsLines = new JavaFileCommentsLines();
        System.out.println(javaFileCommentsLines.getCommentsLines("/Users/si.ma/git/algorithms/others"));
    }
}