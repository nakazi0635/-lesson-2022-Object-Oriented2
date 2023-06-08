package jp.ac.ait.k21085;

import java.util.Random;
import java.util.Scanner;

public class SimpleRPG {

    // このクラスでは、画面からの入力をいろいろなメソッドで行うため、
    // フィールド化しておく
    final static Scanner scanner = new Scanner(System.in);

    Hero hero;
    Enemy enemy;




    public int select;

    /**
     * 勇者を生成して返すメソッド
     * @return
     */
    Hero createHero() {

        //勇者の名前を入力させます
        System.out.println("あなたの名前を入力");
        String name = scanner.nextLine();


        // 以下の表に従ってパラメータを生成
        System.out.println("あなたは今からクレーマーを追い返さないといけません。あなたの職業を選んでください");
        System.out.println("1：趣味ボディビルダー 2：前職芸人（1か2を入力）");

        select = Integer.parseInt(scanner.nextLine());
        System.out.println(select);
        if (select == 1) {
            hero = new Bodybuilder( // パラメータ	ランダム範囲
                    name,
                    new Random().nextInt(41) + 80,  // HP	80 〜 120
                    new Random().nextInt(8) + 8,   // ATK	8 〜 15
                    new Random().nextInt(8) + 8,   // DEF	8 〜 15
                    new Random().nextInt(8) + 8);  // AGI	8 〜 15

        }else if(select == 2) {
            hero = new Comedian( // パラメータ	ランダム範囲
                    name,
                    new Random().nextInt(41) + 80,  // HP	80 〜 120
                    new Random().nextInt(8) + 8,   // ATK	8 〜 15
                    new Random().nextInt(8) + 8,   // DEF	8 〜 15
                    new Random().nextInt(8) + 8);  // AGI	8 〜 15
        }
        if (select == 1){
            System.out.println("特殊攻撃は通常攻撃に加えて１−２０までのダメージが加算されますが成功率は70％です");
        }else if(select == 2){
            System.out.println("特殊攻撃は通常攻撃に１−３倍のダメージを与えますが、成功率は50％です");
        }


        String[] arms = {"一人で解決","相方と一緒に説得","店長と一緒に説得","警察を呼んで一緒に説得"};
        int[] value = {1,2,4,6};
        int i = new Random().nextInt(4);
        Weapon wea = new Weapon(arms[i], value[i]);
        System.out.println(name+"は"+arms[i]+"することにした。攻撃力が"+value[i]+"上がった！");
        hero.setWeapon(wea);
        return hero;
    }

    Enemy createEnemy() {

        String name ="クレーマー";

        Enemy enemy = new Enemy( // パラメータ	ランダム範囲
                name,
                new Random().nextInt(151) + 50,  // HP  	50 〜 200
                new Random().nextInt(11) + 10,  // ATK	10 〜 20
                new Random().nextInt(11) + 5,   // DEF	5 〜 15
                new Random().nextInt(11) + 10); // AGI	10 〜 20

        return enemy;

    }

    /**
     *  勇者の行動
     * @return falseの場合続行不能
     */
    boolean heroAction() {
        // 勇者の1回分の行動決定と行動を行わせるメソッド

        // 画面より、攻撃か逃亡かを選択させ、その行動結果を画面に表示します
        System.out.println("あなたの行動を決めてください(1:攻撃,2:"+((IHeroJob)hero).getSpecialAttackName()+",それ以外:逃亡)");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            // 攻撃だった場合
            AttackResult ret = hero.attack(enemy);//Heroクラスのtargetにenemyが入る

            if (ret.damage == AttackResult.CONTINUE){
                System.out.println("攻撃ミス！"+hero.getName() +"が言い返せなかった");
            }

            if (hero.judge){
                System.out.println("２倍攻撃！"+enemy.getName() +"に大きくダメージ");
                hero.judge = false;
            }

            System.out.println(enemy.getName() + "に" + ret.damage + "のダメージ"+"残りHP："+enemy.getHp());
            if (ret.state == AttackResult.BATTLE_END) {
                // 戦闘終了
                System.out.println(hero.getName() +"は"+ enemy.getName() +"の撃退に成功した。ゲームクリア。");
                return false; // 続行不能
            }
            // 戻り値は、行動により戦闘続行可否をbooleanで返します
            return true;

            }else if(input.equals("2")){

                IHeroJob job = (IHeroJob)hero;
                AttackResult ret1 = job.specialAttack(enemy);


                //System.out.println(((IHeroJob)app.hero).getSpecialAttackName());

                if (ret1.damage == AttackResult.CONTINUE) {
                    System.out.println("攻撃ミス！" + hero.getName() + "が言い返せなかった");
                }

                if (hero.judge) {
                    System.out.println("２倍攻撃！" + enemy.getName() + "に大きくダメージ");
                    hero.judge = false;
                }

                System.out.println(enemy.getName() + "に" + ret1.damage + "のダメージ" + "残りHP：" + enemy.getHp());
                if (ret1.state == AttackResult.BATTLE_END) {
                    // 戦闘終了
                    System.out.println(hero.getName() + "は" + enemy.getName() + "の撃退に成功した。ゲームクリア。");
                    return false; // 続行不能
                }
                // 戻り値は、行動により戦闘続行可否をbooleanで返します
                return true;

            } else {
                // 逃亡だった場合
                System.out.println(hero.getName() + "は逃亡しました。ゲームオーバー");
                return false; // 続行不能
            }
    }

    boolean enemyAction() {
        // 敵の1回分の攻撃行動を行わせるメソッド（敵は攻撃の行動のみ行います）
        // 攻撃だった場合
        AttackResult ret = enemy.attack(hero);

        if (ret.damage == AttackResult.CONTINUE){
            System.out.println("攻撃ミス！"+enemy.getName() +"が言い返せなかった");
        }

        if (hero.judge){
            System.out.println("２倍攻撃！"+hero.getName() +"に大きくダメージ");
            hero.judge = false;
        }

        System.out.println(hero.getName() + "に" + ret.damage + "のダメージ"+"残りHP："+hero.getHp());
        if (ret.state == AttackResult.BATTLE_END) {
            // 戦闘終了
            System.out.println(hero.getName() + "は敗北した。"+ enemy.getName() +"は今も迷惑行為を続けている。ゲームオーバー");
            return false; // 続行不能
        }
        // 戻り値は、行動により戦闘続行可否をbooleanで返します
        return true;
    }

    void battleLoop() {
        //戦闘処理の無限ループを用意します
        while(true) {
            // 無限ループ内では、勇者と敵の素早さを比較し行動順序を入れ替え、それぞれの行動を行います
            // 行動により戦闘続行不可能になった場合は、その場で無限ループを抜け、メソッドを終了します
            if (hero.getAgi() >= enemy.getAgi()) {
                // 勇者のほうが早い
                if (!heroAction()) return;
                if (!enemyAction()) return;
            } else {
                if (!enemyAction()) return;
                if (!heroAction()) return;
            }
        }
    }

    public static void main(String[] args) {
        SimpleRPG app = new SimpleRPG();

        System.out.println("(バイト中)今日も迷惑クレーマーのおっさん来てる。他の客に迷惑だし早く帰ってもらおう");

        app.hero = app.createHero();
        System.out.println(app.hero.getName() + " HP:" + app.hero.getHp() + " ATK:" + app.hero.getAtk() + " DEF:" + app.hero.getDef() + " AGI:" + app.hero.getAgi());
        app.enemy = app.createEnemy();
        System.out.println(app.enemy.getName() + " HP:" + app.enemy.getHp() + " ATK:" + app.enemy.getAtk() + " DEF:" + app.enemy.getDef() + " AGI:" + app.enemy.getAgi());

        app.battleLoop();
    }


}
