package medium;

public class _245ShortestWordDistance3 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
    	int len = Integer.MAX_VALUE;
    	int w1 = -1;
    	int w2 = -1;
        for(int i = 0; i < words.length; i++) {
        	if(words[i].equals(word1)) {
        		if(word1.equals(word2) && w1 != -1) {
        			len = Math.min(len, i-w1);
        		}
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
		_245ShortestWordDistance3 a = new _245ShortestWordDistance3();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes";
		String word2 = "coding";
		System.out.println(a.shortestWordDistance(words, word1, word1));
	}
}
