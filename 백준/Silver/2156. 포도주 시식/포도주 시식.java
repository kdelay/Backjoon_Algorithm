import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int N;

    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        // 초기값 세팅
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];

        // 1 넘는 값부터 dp 세팅 가능(ArrayIndexValid)
        if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(recur(N));
    }

    private static int recur(int n) {
        for (int i=3; i<=N; i++) {
            dp[i] = Math.max( Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i], dp[i-1] );
        }
        return dp[N];
    }
}