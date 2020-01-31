package hr;

import infrastructure.security.IDCard;

abstract public class Person implements IPerson{
    protected  int id;
    protected String name;
    protected int[][] iris;
    protected IDCard idCard;

    public Person() {
        this.iris = new int[10][10];
        this.name = "huhu 1234";
    }

    public String getName(){
        return this.name;
    }

    public int[][] getIris() {
        return this.iris;
    }

    public IDCard getIdCard() {
        return this.idCard;
    }

    public int getID(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
