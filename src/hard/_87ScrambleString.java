package hard;

public class _87ScrambleString {
	//dp到底要保留哪些数据还需要再一次计算
	//要我做可能要设置一个四维的数组来做，而且数组中很多地方不存放数字
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if(len != s2.length()) return false;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
			if(s1.charAt(i)==s2.charAt(i)){
				dp[i][i] = true;
			}else{
				dp[i][i] = false;
			}
		}
        
        for (int size = 2; size <= len; size++){
        	for(int start = 0; start <= len-size; start++){
        		for (int section = 1; section < size; section++){
        			if(dp[start][start+section-1] && dp[start+section][start+size-1]){
        				dp[start][start+size-1] = true;
        				break;
        			}
        			String temp11 = s1.substring(start, start+section);
        			String temp12 = s1.substring(start+section, start+size);
        			String temp21 = s2.substring(start, start+size-section);
        			String temp22 = s2.substring(start+size-section, start+size);
        			if(isScramble(temp11, temp22) && isScramble(temp12, temp21)){
        				dp[start][start+size-1] = true;
        				break;
        			}
        		}
        	}
        }
        return dp[0][len-1];
    }
    
    public boolean isScramble2(String s1, String s2) {
    	if(s1.equals(s2)) return true;
    	if(s1.length()!=s2.length()) return false;
    	int[] letters = new int[26];
    	for (int i = 0; i < s1.length(); i++) {
    		letters[s1.charAt(i)-'a']++;
    		letters[s2.charAt(i)-'a']--;
    	}
    	for (int i = 0; i < letters.length; i++) {
			if(letters[i]!=0) return false;
		}
    	for (int i = 1; i < s1.length(); i++) {
    		if(isScramble2(s1.substring(0, i), s2.substring(0, i)) && isScramble2(s1.substring(i), s2.substring(i)))  return true;
    		if(isScramble2(s1.substring(0, i), s2.substring(s2.length()-i, s2.length())) && isScramble2(s1.substring(i), s2.substring(0, s2.length()-i)))  return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		_87ScrambleString a = new _87ScrambleString();
		
		String s1 = "abcdefghijklmn";
		String s2 = "efghijklmncadb";
		System.out.println(a.isScramble2(s1, s2));
	}
}
