package hard;

import java.util.HashMap;
import java.util.HashSet;

public class _76MinimumWindowSubstring {
	//这个是包含了字母就行
    public String minWindow2(String s, String t) {
    	HashSet<Character> tSet = new HashSet<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
        	tSet.add(t.charAt(i));
        	tMap.put(t.charAt(i), 0);
        }
        int start = 0;
        int end = -1;
        String result = "";
        while(end < s.length()) {
        	if(tSet.isEmpty()) {
        		result = s.substring(start, end+1);////
        		char temp = s.charAt(start);
        		if(!tMap.containsKey(temp)){
        			start++;
        			continue;
        		}
        		if(tMap.get(temp) == 1) {
        			tSet.add(temp);
        		}
        		tMap.put(temp, tMap.get(temp)-1);
        		start++;
        	}else if(end == s.length()-1) {
        		break;
        	}else{
        		end++;
        		char temp = s.charAt(end);
        		if(!tMap.containsKey(temp)) continue;
        		tSet.remove(temp);
        		tMap.put(temp, tMap.get(temp)+1);
        	}
        }
        return result;
    }
    
    //这个得包含t中足够的字母
    public String minWindow(String s, String t) {
    	int[] map = new int[128];
    	int count = t.length();
    	for(int i = 0; i < t.length(); i++) {
    		map[t.charAt(i)]++;
    	}
    	String result = "";
    	int low = 0;
    	int high = Integer.MAX_VALUE;
    	int start = 0;
    	int end = -1;
    	while(end < s.length()) {
    		if(count<=0) {
    			if(high-low > end-start+1) {
    				high = end+1;
    				low = start;
    				result = s.substring(low, high);
    			}
    			int temp = map[s.charAt(start)]++;
    			if(temp >= 0) {
    				count++;
    			}
    			start++;
    		}else{
    			end++;
    			if(end == s.length()) break;
    			int temp = map[s.charAt(end)]--;
    			if(temp > 0) {
    				count--;
    			}
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		_76MinimumWindowSubstring a = new _76MinimumWindowSubstring();
		String s = "cabwefgewcwaefgcf";
		String t = "cae";
		System.out.println(a.minWindow(s, t));
	}
}
