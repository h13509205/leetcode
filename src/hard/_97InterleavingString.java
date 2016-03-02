package hard;

public class _97InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
    	int len1 = s1.length();
    	int len2 = s2.length();
    	int len3 = s3.length();
        if(len1+len2 != len3) return false;
        if(len1 == 0 && s2 != s3) return false;
        if(len2 == 0 && s1 != s3) return false;
        boolean[][] dp = new boolean[len2+1][len1+1];
        dp[0][0] = true;
        for(int column = 1; column <= len1; column++) {
        	if(s1.charAt(column-1) == s3.charAt(column-1)) {
        		dp[0][column] = true;
        	}else {
        		break;
        	}
        }
        for(int row = 1; row <= len2; row++) {
        	if(s2.charAt(row-1) == s3.charAt(row-1)) {
        		dp[row][0] = true;
        	}else {
        		break;
        	}
        }
        for(int row = 1; row <= len2; row++) {
        	for(int column = 1; column <= len1; column++) {
        		if(dp[row-1][column] == true && s2.charAt(row-1) == s3.charAt(row+column-1)) {
        			dp[row][column] = true;
        		}else if(dp[row][column-1] == true && s1.charAt(column-1) == s3.charAt(row+column-1)) {
        			dp[row][column] = true;
        		}
        	}
        }
        return dp[len2][len1];
    }
    
    public static void main(String[] args) {
		_97InterleavingString a = new _97InterleavingString();
		String s1 = "";
		String s2 = "";
		String s3 = "";
		System.out.println(a.isInterleave(s1, s2, s3));
	}
}
