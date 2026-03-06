class Solution {
    public List<String> getNeighbours(String word,HashSet<String> set) {
        List<String> neighbours = new ArrayList<>();
        for(int i = 0; i<word.length(); i++) {
            for(char ch = 'a'; ch<='z'; ch++) {
                if(ch == word.charAt(i)) {
                    continue;
                }
                String newWord = word.substring(0,i) + ch + word.substring(i+1, word.length());
                if(set.contains(newWord)){
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);//to convert wordList in hasSet form

        if(!set.contains(endWord)) {
            return 0;//endWord must contain in wordList while beginWord not need
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        if(set.contains(beginWord)){
            set.remove(beginWord);//agar beginword exist karta hai to usko delete kardo warna exception show kar sakta hai 
        }

        int level = 0;
        while(!q.isEmpty()) {
            int currLevelSize = q.size();

            //levelwise traversal
            for(int i = 0; i<currLevelSize; i++){
                String node = q.poll();

                if(node.equals(endWord)) {
                    return level+1;
                }

                //adjList
                List<String> neighbours = getNeighbours(node,set);
                for(String word : neighbours) {
                    if(set.contains(word)) {
                        q.offer(word);
                        set.remove(word);
                    }

                }
            }
            level++;
        }
        return 0;
    }
}