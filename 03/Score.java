 /*getJapanese	    int	なし	subjects[0]を返します
        getMathmatics	    int	なし	subjects[1]を返します
        getScience	        int	なし	subjects[2]を返します
        getSocialStudies	int	なし	subjects[3]を返します
        getEnglish	        int	なし	subjects[4]を返します
        setJapanese	        void    int value	subjects[0]に引数のvalueを代入します
        setMathmatics	    void    int value	subjects[1]に引数のvalueを代入します
        setScience	        void	int value	subjects[2]に引数のvalueを代入します
        setSocialStudies	void	int value	subjects[3]に引数のvalueを代入します
        setEnglish	        void	int value	subjects[4]に引数のvalueを代入します
        getTotal	        int	なし	subjects[0]〜subjects[4]の合計を算出して返します
        getAverage	        double	なし	合計 / 教科数を算出して返します
        getHighScore	    int	なし	5教科のうち最高得点を返します。(点数のみなので、同率が存在する場合も返す値は1つ)
        getHighScoreSubject	String	なし	5教科のうち最高得点だった科目名を返します。同率の科目がある場合は、カンマ区切りで科目を連結してください。(国語と英語が1位だったら、「国語,英語」が返されます。)
        getLowScore	        int	なし	5教科のうち最低得点を返します。(点数のみなので、同率が存在する場合も返す値は1つ)
        getLowScoreSubject	String	なし	5教科のうち最低得点だった科目名を返します。同率の科目がある場合は、カンマ区切りで科目を連結してください。(国語と英語が同率最低だったら、「国語,英語」が返されます。)
        printInfo	        なし	なし	標準出力に「出席番号 氏名 国語00点,数学00点,理科00点,社会00点,英語00点 合計00点 平均00.00点 得意科目〇〇00点 苦手科目〇〇00点」のように情報出力してください。*/
public class Score {
            /*id	int	出席番号
            name	String	氏名
            subjects	int[5]	点数([0]:国語,[1]:数学,[2]:理科,[3]:社会,[4]:英語)*/
    int id = 0;
    String name = "";
    //int[] subjects = new int[5];
    int[] subjects = new int[5];

    //getJapanese	    int	なし	subjects[0]を返します
    public int getJapanese(){
        return this.subjects[0];
    }
    //getMathmatics	    int	なし	subjects[1]を返します
    public int getMathmatics(){
        return this.subjects[1];
    }
    //getScience	        int	なし	subjects[2]を返します
    public int getScience(){
        return this.subjects[2];
    }
    //getSocialStudies	int	なし	subjects[3]を返します
    public int getSocialStudies(){
        return this.subjects[3];
    }
    //getEnglish	        int	なし	subjects[4]を返します
    public int getEnglish(){
        return this.subjects[4];
    }
    //setJapanese	        void    int value	subjects[0]に引数のvalueを代入します
    public void setJapanese(int value){
        subjects[0] = value;
    }
    //setMathmatics     void    int value	subjects[1]に引数のvalueを代入します
    public void setMathmatics(int value){
        subjects[1] = value;
    }
    //setScience	        void	int value	subjects[2]に引数のvalueを代入します
    public void setScience(int value){
        subjects[2] = value;
    }
    //setSocialStudies	void	int value	subjects[3]に引数のvalueを代入します
    public void setSocialStudies(int value){
        subjects[3] = value;
    }
    //setEnglish	        void	int value	subjects[4]に引数のvalueを代入します
    public void setEnglish(int value){
        subjects[4] = value;
    }



    //getTotal	        int	なし	subjects[0]〜subjects[4]の合計を算出して返します
    public int getTotal(){
        int total = 0;
        for (int i : subjects){
            total += i;
        }
        return total;
    }
    //getAverage	        double	なし	合計 / 教科数を算出して返します
    public double getAverage(){
        double ave;
        ave = (double)getTotal()/subjects.length;
        return ave;
    }
    //getHighScore	    int	なし	5教科のうち最高得点を返します。(点数のみなので、同率が存在する場合も返す値は1つ)
    public int getHighScore(){
        int high = 0;
        for (int i : subjects){
            if (high < i){
                high = i;
            }
        }
        return high;
    }
    //getHighScoreSubject	String	なし	5教科のうち最高得点だった科目名を返します。同率の科目がある場合は、カンマ区切りで科目を連結してください。(国語と英語が1位だったら、「国語,英語」が返されます。)
    public String getHighScoreSubject(){
        int max = getHighScore();
        String subjectname = "";
        for (int i = 0;i < subjects.length; i++) {
            if (max == subjects[i]){
                switch(i){
                    case 0:
                        subjectname += "国語";
                        break;
                    case 1:
                        subjectname += "数学";
                        break;
                    case 2:
                        subjectname += "理科";
                        break;
                    case 3:
                        subjectname += "社会";
                        break;
                    case 4:
                        subjectname += "英語";
                        break;
                }
            }
        }
        return subjectname;
    }
    //getLowScore	        int	なし	5教科のうち最低得点を返します。(点数のみなので、同率が存在する場合も返す値は1つ)
    public int getLowScore(){
        int min = 100;
        for (int i : subjects){
            if (min > i){
                min = i;
            }
        }
        return min;
    }
    //getLowScoreSubject	String	なし	5教科のうち最低得点だった科目名を返します。同率の科目がある場合は、カンマ区切りで科目を連結してください。(国語と英語が同率最低だったら、「国語,英語」が返されます。)
    public String getLowScoreSubject(){
        int min = getLowScore();
        String subjectnamemin = "";
        for (int i = 0;i < subjects.length; i++){
            if (min == subjects[i]){
                switch (i){
                    case 0:
                        subjectnamemin += "国語";
                        break;
                    case 1:
                        subjectnamemin += "数学";
                        break;
                    case 2:
                        subjectnamemin += "理科";
                        break;
                    case 3:
                        subjectnamemin += "社会";
                        break;
                    case 4:
                        subjectnamemin += "英語";
                        break;
                }
            }
        }
        return subjectnamemin;
    }
    //printInfo	        なし	なし	標準出力に「出席番号 氏名 国語00点,数学00点,理科00点,社会00点,英語00点 合計00点 平均00.00点 得意科目〇〇00点 苦手科目〇〇00点」のように情報出力してください。*/
     public void printInfo(){
        System.out.printf("出席番号%d 氏名%s 国語%d点,数学%d点,理科%d点,社会%d点,英語%d点\n 合計%d点 平均%.2f点 得意科目%s,%d点 苦手科目%s,%d点",id,name,getJapanese(),getMathmatics(),getScience(),getSocialStudies(),getEnglish(),getTotal(),getAverage(),getHighScoreSubject(),getHighScore(),getLowScoreSubject(),getLowScore());
        //System.out.println(getLowScoreSubject());
    }
}
