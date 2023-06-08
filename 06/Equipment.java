package jp.ac.ait.k21085;

public class Equipment {
    private String name;
    public Equipment(String name){
        this.name = name;
    }
    public Equipment(){
        this.name = "装備";
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return this.name;
    }
}
