package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import utils.ArrayUtils;

/**
 * 单词接龙 II
 * https://leetcode-cn.com/problems/word-ladder-ii/
 * @author masikkk.com 2020-06-07 20:45
 */
public class _126_WordLadder2 {
    private static class SolutionV202006 {
        Map<String, Set<String>> graph;
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            // wordList 中不包含 endWord 直接返回空
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return Collections.emptyList();
            }

            // 初始化图存储结构，邻接点 map, str -> Set 表示 str 的邻接点是 Set 中的元素（可以这样存的前提是图中无重复结点）
            graph = new HashMap<>();
            initGraph(wordList, beginWord);

            // 标识已访问过的结点
            Set<String> visited = new HashSet<>();

            // 结果集
            List<List<String>> res = new ArrayList<>();

            // queue 中存储的是每个结点及其父节点序列，从前往后存储，getLast() 是当前节点
            Queue<LinkedList<String>> queue = new LinkedList<>();
            queue.offer(new LinkedList<>(Arrays.asList(beginWord)));
            // BFS 层次遍历
            while (!queue.isEmpty()) {
                boolean find = false; // 当前层是否找到 endWord，找到则停止BFS
                int levelSize = queue.size(); // 当前层结点数
                for (int i = 0; i < levelSize; i++) {
                    LinkedList<String> strList = queue.poll();
                    visited.add(strList.getLast()); // 标记为已访问过
                    // 找当前节点 strList.getLast() 能转换成的结点集合
                    Set<String> convertSet = graph.get(strList.getLast());
                    if (convertSet.contains(endWord)) {
                        // 当前层已到达 endWord
                        find = true;
                        strList.add(endWord);
                        res.add(strList);
                    }
                    // 从可转换集合中排除已遍历过的结点，并依次和父节点 list 拼接后加入 queue
                    convertSet.stream().filter(str -> !visited.contains(str)).forEach(str -> {
                        LinkedList<String> newList = new LinkedList<>(strList);
                        newList.add(str);
                        queue.add(newList);
                    });
                }
                if (find) {
                    // 当前层已到达 endWord，结束 BFS
                    break;
                }
            }
            return res;
        }

        // 初始化图存储结构，邻接点 map, str -> Set 表示 str 的邻接点是 Set 中的元素（可以这样存的前提是图中无重复结点）
        private void initGraph(List<String> wordList, String beginWord) {
            graph.put(beginWord, findConvertSet(wordList, beginWord));
            wordList.forEach(str -> graph.put(str, findConvertSet(wordList, str)));
        }

        // 返回 wordList 中可以被 target 转换成的字符串集合
        private Set<String> findConvertSet(List<String> wordList, String target) {
            return wordList.stream().filter(str -> convertable(target, str)).collect(Collectors.toSet());
        }

        // str1 改变一个字符可以转换为 str2 时返回 true
        private boolean convertable(String str1, String str2) {
            int diffCount = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    diffCount++;
                }
                if (diffCount > 1) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        ArrayUtils.printListList(solutionV202006.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        ArrayUtils.printListList(solutionV202006.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
        ArrayUtils.printListList(solutionV202006.findLadders("hit", "hit", Arrays.asList("hit")));
        ArrayUtils.printListList(solutionV202006.findLadders("cet", "ism",
                Arrays.asList("kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now",
                        "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali",
                        "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own",
                        "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat",
                        "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san",
                        "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl",
                        "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab",
                        "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit",
                        "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo",
                        "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web",
                        "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee",
                        "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog",
                        "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat",
                        "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop",
                        "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox",
                        "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix",
                        "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via",
                        "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos",
                        "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix",
                        "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado",
                        "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad",
                        "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod",
                        "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun",
                        "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun",
                        "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei",
                        "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux",
                        "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann",
                        "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min",
                        "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora",
                        "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig",
                        "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace",
                        "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow",
                        "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud",
                        "gee", "pin", "dun", "pat", "ten", "mob")));
    }
}