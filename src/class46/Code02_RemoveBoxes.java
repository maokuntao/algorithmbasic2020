package class46;

// 本题测试链接 : https://leetcode.com/problems/remove-boxes/
public class Code02_RemoveBoxes {

	public static int removeBoxes(int[] boxes) {
		int N = boxes.length;
		int[][][] dp = new int[N][N][N];
		int ans = process(boxes, 0, N - 1, 0, dp);
		return ans;
	}

	public static int process(int[] boxes, int L, int R, int K, int[][][] dp) {
		if (L > R) {
			return 0;
		}
		if (dp[L][R][K] > 0) {
			return dp[L][R][K];
		}
		int ans = process(boxes, L, R - 1, 0, dp) + (K + 1) * (K + 1);
		for (int i = L; i < R; i++) {
			if (boxes[i] == boxes[R]) {
				ans = Math.max(ans, process(boxes, i + 1, R - 1, 0, dp) + process(boxes, L, i, K + 1, dp));
			}
		}
		dp[L][R][K] = ans;
		return ans;
	}

}