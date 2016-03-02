package medium;

import java.util.HashMap;

public class _319BulbSwitcher {
    public int bulbSwitchTest(int n) {
        int num = 0;
        int[] bulbs = new int[n+1];
        for(int gap = 1; gap <= n; gap++) {
        	for(int i = 1; i*gap <= n; i++) {
        		bulbs[i*gap]++;
        	}
        }
        for(int i = 1; i <= n; i++) {
        	num = num + bulbs[i]%2;
        }
        return num;
    }
    
    public int bulbSwitch(int n) {
    	int num = 0;
    	if(n == 0) return 0;
    	for(int i = 1; i <= Integer.MAX_VALUE; i++) {
    		if((i*i+2*i >= n) && (i*i-1) < n) return i;
    	}
    	return 0;
    }
    
    public int bulbSwitchEasy(int n) {
    	return (int) Math.sqrt(n);
    }
    
    public static void main(String[] args) {
		_319BulbSwitcher a = new _319BulbSwitcher();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int n = 1; n < 1000; n++) {
			int num = a.bulbSwitch(n);
			System.out.println(n+" : "+num);
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}else{
				map.put(num, 1);
			}
		}
		for(int key : map.keySet()) {
			System.out.println(key+" : "+map.get(key));
		}
	}
}
