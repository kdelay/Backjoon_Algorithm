import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(arr[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int px = poll[0];
            int py = poll[1];

            for (int i=0; i<4; i++) {
                int a = px + dx[i];
                int b = py + dy[i];

                if (a >= 0 && b >= 0 && a < N && b < M && arr[a][b] == 1 && !visited[a][b]) {
                    queue.add(new int[]{a, b});
                    visited[a][b] = true;
                    arr[a][b] = arr[px][py] + 1; //도착할 수 있는 경우의 수 증가
                }
            }
        }

    }
}