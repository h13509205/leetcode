package hard;

public class _10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(quickSolve(p)){
        	return true;
        }
        int plen = p.length();
        int slen = s.length();
        for(int i = 0; i < plen; i++) {
        	int idx = i;
        	for(int j = 0; j <= slen; j++) {
        		if(j == slen) return true;
        		if(idx == plen) return false;
        		if(p.charAt(idx)=='*') {
        			if(p.charAt(idx-1) != s.charAt(j)) {
        				j--;
        				idx++;
        			}
        		}else if(p.charAt(idx)=='.') {
        			idx++;
        		}else if(p.charAt(idx) != s.charAt(j)) {
        			break;
        		}else if(p.charAt(idx) == s.charAt(j)) {
        			idx++;
        		}
        	}
        }
        return false;
    }
    
    public boolean quickSolve(String p) {
    	for(int i = 0; i < p.length(); i++) {
    		if(p.charAt(i)=='.' && (i<p.length()-1&&p.charAt(i+1)=='*')){
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		_10RegularExpressionMatching a = new _10RegularExpressionMatching();
		String s = "aa";
		String p = "a";
		System.out.println(a.isMatch(s, p));
	}
}
