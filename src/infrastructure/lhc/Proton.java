package infrastructure.lhc;

public class Proton {
    private int[][][] structure;
    private double weight;

    public  Proton(){
        this.structure = new int [100][100][100];
    }

    public void setStructure(int x1, int x2, int x3, int value){
        this.structure[x1][x2][x3] = value;
    }

    public int[][][] getStructure(){
        return structure;
    }
}
