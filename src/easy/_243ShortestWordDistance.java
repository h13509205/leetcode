package easy;

public class _243ShortestWordDistance {
	//O(n)时间，我感觉
    public int shortestDistance(String[] words, String word1, String word2) {
    	int len = Integer.MAX_VALUE;
    	int w1 = -1;
    	int w2 = -1;
        for(int i = 0; i < words.length; i++) {
        	if(words[i].equals(word1)) {
        		w1 = i;
        		if(w2 != -1) {
        			len = Math.min(len, Math.abs(w1-w2));
        		}
        	}else if(words[i].equals(word2)) {
        		w2 = i;
        		if(w1 != -1) {
        			len = Math.min(len, Math.abs(w1-w2));
        		}
        	}
        }
        return len;
    }
    
    public static void main(String[] args) {
		_243ShortestWordDistance a = new _243ShortestWordDistance();
		String[] words = {"a","a","b","b"};
		String word1 = "a";
		String word2 = "b";
		System.out.println(a.shortestDistance(words, word1, word2));
	}
}
