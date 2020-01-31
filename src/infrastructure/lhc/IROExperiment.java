package infrastructure.lhc;

import java.util.UUID;


public interface IROExperiment {
    public UUID getUUID();
    public String getTimeStamp();
    public boolean getIsHiggsBosonFound();
    public Block[] getBlocks();
}
