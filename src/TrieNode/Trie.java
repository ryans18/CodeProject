package TrieNode;

/**
 * Author : Ryans
 * Date : 2022/9/1
 * Introduction : 前缀树(单词查找树，字典树)
 */
public class Trie {

    static TrieNode root;
    public static void main(String[] args) {
        root = new TrieNode();
        add("abc");
        add("dbe");
        add("ab");
        add("bce");
        add("ab");
        System.out.println(search("ab"));
        System.out.println(prefixNum("ab"));
    }

    private static void add(String word) {
        char[] chars = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (char aChar : chars) {
            index = aChar - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node.pass++;
            node = node.nexts[index];
        }
        node.pass++;
        node.end++;
    }

    private static int search(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (char aChar : chars) {
            index = aChar - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    // 所有加入的字符中，有几个是以word为前缀的
    private static int prefixNum(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (char aChar : chars) {
            index = aChar - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    private static void delete(String word) {
        if (search(word) != 0) {
            char[] chars = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            for (char aChar : chars) {
                index = aChar- 'a';
                node.pass--;
                node = node.nexts[index];
            }
            node.end--;
            if (node.pass == 0) {
                node.nexts[index] = null;
            }
        }
    }

    private static class TrieNode {
        public int pass; // 当前节点经过了几次
        public int end; // 以当前节点结尾次数
        public TrieNode[] nexts;

        private TrieNode() {
            nexts = new TrieNode[26]; // 26个字母
        }
    }

}
