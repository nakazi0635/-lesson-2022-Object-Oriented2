public class ScoresSorter {
    public static void main(String[] args) {
        String[] names = { "佐藤一郎", "鈴木次郎", "高橋三郎", "田中四郎", "伊藤五郎", "渡辺六郎", "山本七子", "中村八郎", "小林九", "加藤十子" };
        int[][] scores = {
                { 100, 30, 50, 40, 50, 60, 70, 80, 95, 10 },
                { 30, 55, 45, 60, 65, 50, 80, 25, 100, 35 },
                { 90, 75, 35, 90, 65, 60, 80, 25, 0, 20 },
                { 10, 85, 25, 70, 90, 80, 60, 50, 40, 30 },
                { 60, 40, 30, 50, 70, 70, 70, 70, 15, 55 },
        };
        
        int[] totals = new int[scores[0].length];
        for (int i = 0; i < names.length; i++) {
            totals[i] = scores[0][i] + scores[1][i] + scores[2][i] + scores[3][i] + scores[4][i];
        }
        int tmp = 0;
        String S_tmp;
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (totals[i] < totals[j]) {
                    tmp = totals[i];
                    totals[i] = totals[j];
                    totals[j] = tmp;

                    S_tmp = names[i];
                    names[i] = names[j];
                    names[j] = S_tmp;
                }
            }
        }
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]+":"+totals[i]);
        }

    }
}
