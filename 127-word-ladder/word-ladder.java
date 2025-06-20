class Pair {
    String s;
    int i;
    public Pair(String s, int i) {
        this.s = s;
        this.i = i;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++) {
            words.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        words.remove(beginWord);
        while(!q.isEmpty()) {
            String temp = q.peek().s;
            int cur = q.peek().i;
            if(temp.equals(endWord)) return cur;
            q.poll();
            for(int i = 0; i < beginWord.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] arr = temp.toCharArray();
                    arr[i] = ch;
                    String st = new String(arr);
                    if(words.contains(st)) {
                        q.offer(new Pair(st, cur + 1));
                        words.remove(st);
                    }
                }
            }
        }
        return 0;
    }
}