import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KnightsShift {
    static int I;
    static int x1, x2, y1, y2;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            I = Integer.parseInt(br.readLine());

            arr = new int[I][I];
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs();

            sb.append(arr[x2][y2]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1});
        visited[x1][y1] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 8; i++) {
                int ox = nx + dx[i];
                int oy = ny + dy[i];

                if (ox >= 0 && oy >= 0 && ox < I && oy < I) {
                    if (!visited[ox][oy]) {
                        q.add(new int[]{ox, oy});
                        arr[ox][oy] = arr[nx][ny] + 1;
                        visited[ox][oy] = true;
                    }
                }
            }
        }
    }
}




//public class KnightsShift {
//    static StringBuilder answer = new StringBuilder();
//    static int I;
//
//    static class Coordinate {
//        int x;
//        int y;
//        public Coordinate(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public int getX() {
//            return this.x;
//        }
//
//        public int getY() {
//            return this.y;
//        }
//
//    }
//
//    static class ChessBoard {
//        List<Coordinate> coordinates = new ArrayList<>();
//        int[][] knightOffsets = {
//                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
//                {1, 2}, {-1, 2}, {1, -2}, {-1, -2}
//        };
//
//        public ChessBoard(int I) {
//            for (int i = 0; i < I; i++) {
//                for (int j = 0; j < I; j++) {
//                    coordinates.add(new Coordinate(i, j));
//                }
//            }
//        }
//
//        public Coordinate getCoordinate(int x, int y) {
//            int index = x + (y * I);
//            if (index >= 0 && index < I * I - 1) {
//                System.out.println("index는 " + index + "입니다");
//                return coordinates.get(index);
//            } else {
//                return null;
//            }
//        }
//
//        public List<Coordinate> getKnightWays(int x, int y) {
//            List<Coordinate> knightWays = new ArrayList<>();
//            for (int[] knightOffset : knightOffsets) {
//                int newX = x + knightOffset[0];
//                int newY = y + knightOffset[1];
//                System.out.println(newX + "가 x이고" + newY + "가 y입니다");
//                Coordinate coordinate = getCoordinate(newX, newY);
//                if (coordinate != null) {
//                    knightWays.add(getCoordinate(newX, newY));
//                }
//            }
//            return knightWays;
//        }
//    }
//
//    static void bfs(int startX, int startY, int targetX, int targetY) {
//        ChessBoard chessBoard = new ChessBoard(I);
//        Queue<Coordinate> queue = new LinkedList<>();
//        Set<Coordinate> visited = new HashSet<>();
//        int step = 0;
//
//        Coordinate startCoordinate = chessBoard.getCoordinate(startX, startY);
//        Coordinate targetCoordinate = chessBoard.getCoordinate(targetX, targetY);
//        queue.add(startCoordinate);
//        visited.add(startCoordinate);
//
//        while (!queue.isEmpty()) {
//
//            int levelSize = queue.size(); // 현재 레벨의 크기
//            for (int i = 0; i < levelSize; i++) {
//
//                Coordinate currentCoordinate = queue.poll();
//                List<Coordinate> knightWays = chessBoard.getKnightWays(currentCoordinate.getX(), currentCoordinate.getY());
//
//                for (Coordinate knightWay : knightWays) {
//                    if (!visited.contains(knightWay)) {
//                        if (knightWay.equals(targetCoordinate)) {
//                            answer.append(step).append("\n");
//                            return;
//                        } else {
//                            queue.add(knightWay);
//                            visited.add(knightWay);
//                        }
//                    }
//                }
//            }
//            step++;
//        }
//        answer.append(step).append("\n");
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < T; i++) {
//            I = Integer.parseInt(br.readLine());
//
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            int startX = Integer.parseInt(st.nextToken());
//            int startY = Integer.parseInt(st.nextToken());
//
//            st = new StringTokenizer(br.readLine(), " ");
//            int targetX = Integer.parseInt(st.nextToken());
//            int targetY = Integer.parseInt(st.nextToken());
//
//
//            bfs(startX, startY, targetX, targetY);
//        }
//
//        answer.deleteCharAt(answer.length() - 1);
//        System.out.println(answer);
//    }
//
//
//}
