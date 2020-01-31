package infrastructure.lhc;

public interface IExperiment extends IROExperiment{
    public void setIsHiggsBosonFound(boolean found);
    public void setBlocks(Block[] blocks);
}
