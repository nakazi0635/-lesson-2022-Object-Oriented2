package jp.ac.ait.k21085;

public class Response {
    private int hit;
    private int blow;

    public Response(){
        this(0,0);
        System.out.println("デフォルトコンストラクタ");
    }
    public Response(int hit, int blow){

    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getBlow(){
        return blow;
    }

    public void setBlow(int blow){
        this.blow = blow;
    }
}
