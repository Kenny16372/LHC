package infrastructure.lhc;

import infrastructure.lhc.Block;

import java.util.Date;
import java.util.UUID;

public class Experiment implements IExperiment{
    private final UUID uuid;
    private final String dateTimeStamp;
    private boolean isHiggsBosonFound;
    private Block[] blocks;

    public Experiment(UUID uuid, String dateTimeStamp){
        this.uuid = uuid;
        this.dateTimeStamp = dateTimeStamp;
        this.blocks = new Block[200000];
    }

    public Experiment() {
        this.uuid = UUID.randomUUID();
        this.dateTimeStamp = new Date().toString();
    }

    @Override
    public void setIsHiggsBosonFound(boolean found) {
        this.isHiggsBosonFound = found;
    }

    @Override
    public void setBlocks(Block[] blocks) {
        this.blocks = blocks;
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    @Override
    public String getTimeStamp() {
        return this.dateTimeStamp;
    }

    @Override
    public boolean getIsHiggsBosonFound() {
       return this.isHiggsBosonFound;
    }

    @Override
    public Block[] getBlocks() {
        return this.blocks;
    }
    
    
}
