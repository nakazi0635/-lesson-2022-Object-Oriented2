package jp.ac.ait.k21085;

import java.util.Random;

public class Comedian extends Hero implements IHeroJob {

    public Comedian(String name, int hp, int atk, int def, int agi) {
        super(name, hp, atk, def, agi);
    }

    @Override
    public String getJobName() {
        return "前職芸人";
    }

    @Override
    public String getSpecialAttackName() {
        return "弾丸トーク攻撃";
    }

    /**
     * 剣士の全力攻撃は50％の確率で成功し、成功時は必ずクリティカルヒット、ダメージ量は3倍となる
     *
     * @param target 行動対象(基本的に敵が渡されます)
     * @return 行動結果
     */
    @Override
    public AttackResult specialAttack(CharacterBase target) {

        // 引数の攻撃対象に対して与えることのできるダメージを算出
        // 与えるダメージ = 自身の攻撃力 - 敵の防御力 / 2 (小数点以下切り上げ) に、-3〜+3のランダムな値を加算
        int damage = (int) Math.ceil((double) this.getAtk() - (target.getDef() / 2.0))
                + (new java.util.Random().nextInt(7) - 3); // ← −3〜+3のランダムな値

        int successRate = 50;  // 攻撃成功率

        if (new Random().nextInt(100) >= successRate) { // 失敗判定
            AttackResult ret = new AttackResult();
            ret.damage = 0;
            System.out.println(getSpecialAttackName()+"失敗・・・");
            return ret;
        }
        System.out.println(getSpecialAttackName()+"成功！");
        //確率で1-3倍になる
        damage *= Math.ceil(new java.util.Random().nextInt(3));

        // 引数の攻撃対象がダメージを受ける
        boolean isBattleEnd = target.receiveDamage(damage);

        // 攻撃を行ったことによる行動結果を生成して返す
        AttackResult ret = new AttackResult();
        ret.damage = damage;
        if (isBattleEnd) {
            // 戦闘終了の条件を満たす場合、勇者の勝利となる
            ret.state = AttackResult.BATTLE_END;
        }

        return ret;
    }

    @Override
    public String toString() {
        // デバッグ用に職業メッセージを追加しておきます。
        return super.toString() + ", " + this.getJobName() + "(" + this.getSpecialAttackName() + ")";
    }
}