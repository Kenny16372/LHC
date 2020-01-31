package infrastructure.lhc;

import infrastructure.lhc.Ring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;

public class ProtonTrap {
    private ProtonTrapID id;
    public Stack<Proton> protons;
    private Ring ring;

    public void loadData(String dataFilePath){
        try {
            FileInputStream stream = new FileInputStream(dataFilePath);
            while(stream.available() > 0){
                Proton proton = new Proton();
                outerloop: for(int i=0; i < 100; i++){
                    for(int k=0; k < 100; k++){
                        for(int m=0; m < 100; m++){
                            int value = stream.read();
                            if(value == -1){
                                break outerloop;
                            }
                            proton.setStructure(i, k, m, value);
                        }
                    }
                }
                protons.push(proton);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void release(){
    
    }
    public ProtonTrap(){
        this.protons = new Stack<Proton>();
    }
}
