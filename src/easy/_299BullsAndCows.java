package easy;

public class _299BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] digits = new int[10];
        for(int i = 0; i < secret.length(); i++) {
        	if(secret.charAt(i) == guess.charAt(i)) {
        		bulls++;
        	}else{
        		digits[secret.charAt(i) - '0']++;
        	}
        }
        
        for(int i = 0; i < guess.length(); i++) {
        	if(secret.charAt(i) == guess.charAt(i)) {
        		continue;
        	}else if(digits[guess.charAt(i) - '0'] > 0) {
    			cows++;
    			digits[guess.charAt(i) - '0']--;
    		}
        }
        return bulls+"A"+cows+"B";
    }
    
    public static void main(String[] args) {
		_299BullsAndCows a = new _299BullsAndCows();
		String secret = "1123";
		String guess = "0111";
		System.out.println(a.getHint(secret, guess));
	}
}
