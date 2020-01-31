package infrastructure.lhc;

public class Proton {
    private char[][][] structure;
    private double weight;

    public  Proton(){
        this.structure = new char [100][100][100];
    }

    public void setStructure(int x1, int x2, int x3, char value){
        this.structure[x1][x2][x3] = value;
    }

    public char[][][] getStructure(){
        return structure;
    }
}
