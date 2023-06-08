package jp.ac.ait.k21085;

public class Manager {

    private int count;
    private String answer;

    public Manager() {
        this.count = 0;
        Answer answer = new Answer();
        this.answer = answer.get();
    }

    //  countを返す
    public int getCount() {

        return count;
    }

    //answerを返す
    public String getAnswer() {return answer;}
//    countに1を足し、試行回数をカウントアップ
//    Hit, Blowを計算し、Responseのインスタンスで返します。
//    ここで、Blowの数に、Hitの数は含まれない点を注意してください。

    public Response solve(String in) {
        this.count++;
        //System.out.println(getAnswer());

        int hit = 0;
        int blow = 0;
        char[] inp = new char[3];
        char[] ans = new char[3];
        for (int i = 0; i < in.length(); i++) {
            ans[i] = getAnswer().charAt(i);
            inp[i] = in.charAt(i);
        }
        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < in.length(); j++) {
                if (ans[i] == inp[j]) {
                    if (i == j) {
                        hit++;
                        continue;
                    }
                    blow++;
                }
            }
        }
        Response test = new Response(hit,blow);
        test.setHit(hit);
        test.setBlow(blow);

        return test;
    }
}
