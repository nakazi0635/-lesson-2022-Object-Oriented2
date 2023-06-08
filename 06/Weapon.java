package jp.ac.ait.k21085;

public class Weapon extends Equipment{
    private int atk;
    public Weapon(String name, int atk){
        super(name);
        this.atk = atk;
    }
    public Weapon(){
        this.atk = 0;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
}
