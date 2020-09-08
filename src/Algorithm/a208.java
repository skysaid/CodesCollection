package Algorithm;
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
public class a208 {
    class Trie {
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node=this.root;
            for (char c: word.toCharArray()){
                if (!node.containsKey(c)){
                    node.put(c,new TrieNode());
                }
                node=node.get(c);
            }
            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node=this.root;
            for (char c:word.toCharArray()){
                if (node.containsKey(c)){
                    node=node.get(c);
                }
                else return false;
            }
            return node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node=this.root;
            for (char c:prefix.toCharArray()){
                if (node.containsKey(c)){
                    node=node.get(c);
                }
                else return false;
            }
            return true;
        }

        class TrieNode{
            private TrieNode[] links;
            private int range=26;
            private boolean isEnd;

            public TrieNode(){
                this.links=new TrieNode[range];
            }
            public boolean containsKey(char ch) {
                return links[ch -'a'] != null;
            }
            public TrieNode get(char ch) {
                return links[ch -'a'];
            }
            public void put(char ch, TrieNode node) {
                links[ch -'a'] = node;
            }
            public void setEnd() {
                isEnd = true;
            }
            public boolean isEnd() {
                return isEnd;
            }
        }
    }

}
