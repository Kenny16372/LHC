package infrastructure.lhc;

import infrastructure.lhc.Ring;

import java.io.*;
import java.nio.Buffer;
import java.util.Stack;

public class ProtonTrap {
    private ProtonTrapID id;
    public Stack<Proton> protons;
    private Ring ring;

    public void loadData(String dataFilePath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataFilePath));
            String input = reader.readLine();
            int counter = 0;
            Proton proton = new Proton();
            outerloop: for(int x=0; x < 100; x++){
                for(int y=0; y < 100; y++){
                    for(int z=0; z < 100; z++){
                        proton.setStructure(x, y, z, input.charAt(counter));
                        counter++;
                    }
                }
            }
            protons.push(proton);

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
