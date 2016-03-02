package hard;

public class _132PalindromePartitioning2 {
	
	//超时啦
    public int minCut(String s) {
        int len = s.length();
        int dp[][] = new int[len][len];
        for(int i = 0; i < len; i++) {
        	dp[i][i] = 1;
        }
        for(int size = 2; size <= len; size++) {
        	for(int i = 0; i+size-1<len; i++) {
        		if(isPalindrome(s.substring(i, i+size))) {
        			dp[i][i+size-1] = 1;
        			continue;
        		}
        		for(int j=1; j<size; j++) {
        			if(dp[i][i+size-1]==0){
        				dp[i][i+size-1] = dp[i][i+j-1]+dp[i+j][i+size-1];
        			}else{
        				dp[i][i+size-1] = Math.min(dp[i][i+size-1], dp[i][i+j-1]+dp[i+j][i+size-1]);
        			}
        		}
        	}
        }
        return dp[0][len-1]-1;
    }
    
    public boolean isPalindrome(String s) {
    	int start = 0;
    	int end = s.length()-1;
    	while(start<end) {
    		if(s.charAt(start) != s.charAt(end)) {
    			return false;
    		}
    		start++;
    		end--;
    	}
    	return true;
    }
    
    //go over Manacher's ALGORITHM
    public int minCut2(String s) {
    	int n = s.length();
    	int[] cut = new int[n+1];
    	for(int i = 0; i<=n; i++) {
    		cut[i] = i;
    	}
    	for(int i = 0; i < n; i++) {
    		//odd 
    		for(int j = 0; i+j<n && i-j>=0 && s.charAt(i-j)==s.charAt(i+j); j++) {
    			cut[i+j+1] = Math.min(cut[i+j+1], 1+cut[i-j]);
    		}
    		//even
    		for(int j = 0; i-j>=0 && i+j+1<n && s.charAt(i-j)==s.charAt(i+j+1); j++) {
    			cut[i+j+2] = Math.min(cut[i+j+2], 1+cut[i-j]);
    		}
    	}
        return cut[n]-1;
    }
    
    public static void main(String[] args) {
    	_132PalindromePartitioning2 a = new _132PalindromePartitioning2();
		String s = "aabb";
		System.out.println(a.minCut2(s));
	}
}
