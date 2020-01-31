package infrastructure.lhc.events;

import infrastructure.security.ControlCenter;
import infrastructure.security.ExperimentScope;

public class RunExperimentPartial {
    public final int initialEnergy;
    public final ExperimentScope scope;
    public final ControlCenter controlCenter;
    public RunExperimentPartial(int initialEnergy, ExperimentScope scope, ControlCenter controlCenter){
        this.controlCenter = controlCenter;
        this.initialEnergy = initialEnergy;
        this.scope = scope;
    }   
}
