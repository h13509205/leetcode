package hard;

public class _188BestTimeToBuyAndSellStock4 {
	//memory limit exceeded 还是k太大，数值太多的原因，减少dp保存的数量应该可行
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;
        if(len<2) return 0;
        if (k >= len / 2) return quickSolve(prices);
        int[][] dp1 = new int[k+1][len]; //以i结尾卖出的局部最大值
        int[][] dp2 = new int[k+1][len]; //全局最大值ֵ
        int money = prices[1]-prices[0];
        for(int i=1; i<=k; i++) {
        	dp1[i][1] = Math.max(0, money);
        	dp2[i][1] = Math.max(0, money);
        }
        
        for(int i=2; i<len; i++) {
        	money = prices[i]-prices[i-1];
        	for(int j=1; j<=k; j++) {
        		dp1[j][i] = max(dp1[j-1][i], dp2[j-1][i-2]+money, dp1[j][i-1]+money);
        		dp2[j][i] = max(dp2[j][i-1], dp1[j][i]);
        	}
        }
        return dp2[k][len-1];
    }
	
	public int maxProfit2(int k, int[] prices) {
		int len = prices.length;
        if(len<2) return 0;
        if (k >= len / 2) return quickSolve(prices);
        int[] dp1 = new int[len]; //局部
        int[] dp2 = new int[len]; //全局
        for(int j=1; j<=k; j++) {
        	int money = prices[1]-prices[0];
        	int[] temp1 = new int[len]; //局部
        	int[] temp2 = new int[len]; //全局
        	temp1[1] = max(0, money);
        	temp2[1] = max(0, money);
        	for(int i=2; i<len; i++) {
        		money = prices[i]-prices[i-1];
        		temp1[i] = max(dp1[i], dp2[i-2]+money, temp1[i-1]+money);
        		temp2[i] = max(temp2[i-1], temp1[i]);
        	}
        	dp1 = temp1;
        	dp2 = temp2;
        }
        return dp2[len-1];
	}
	
	private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

	
	public int max(int... nums) {
    	int max = Integer.MIN_VALUE;
    	for(int num:nums) {
    		max = Math.max(max, num);
    	}
    	return max;
    }
	
	public static void main(String[] args) {
		_188BestTimeToBuyAndSellStock4 a = new _188BestTimeToBuyAndSellStock4();
		int[] prices = new int[]{3,3,5,0,0,3,1,4};
		System.out.println(a.maxProfit2(2, prices));
	}
}
