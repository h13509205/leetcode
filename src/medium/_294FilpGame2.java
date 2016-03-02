package medium;

import java.util.ArrayList;
import java.util.List;

public class _294FilpGame2 {
    public boolean canWin(String s) {
    	if(s.length() == 0) return false;
        char[] ss = s.toCharArray();
        return helper(ss);
    }
    
    public boolean helper(char[] ss) {
    	for(int i = 0; i < ss.length-1; i++) {
    		if(ss[i]=='+' && ss[i+1]=='+') {
    			ss[i] = '-';
    			ss[i+1] = '-';
    			boolean win = !helper(ss);
    			ss[i] = '+';
    			ss[i+1] = '+';
    			if(win) return true;
    		}
    	}
    	return false;
    }
    
    public boolean canWinDP(String s) {
        s = s.replace('-', ' ');
        int G = 0;
        List<Integer> g = new ArrayList<>();
        for (String t : s.split("[ ]+")) {
            int p = t.length();
            if (p == 0) continue;
            while (g.size() <= p) {
                char[] x = t.toCharArray();
                int i = 0, j = g.size() - 2;
                while (i <= j)
                    x[g.get(i++) ^ g.get(j--)] = '-';
                g.add(new String(x).indexOf('+'));
            }
            G ^= g.get(p);
        }
        return G != 0;
    }
    
    public static void main(String[] args) {
		_294FilpGame2 a = new _294FilpGame2();
		String s = "++++++++";
		System.out.println(a.canWin(s));
	}
}
