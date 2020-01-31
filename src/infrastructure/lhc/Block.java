package infrastructure.lhc;

import java.util.UUID;

public class Block {
    private UUID uuid;
    private String structure;

    public Block(UUID uuid, String structure){
        this.uuid = uuid;
        this.structure = structure;
    }
    
    public String getStructure(){
        return structure;
    }
}
