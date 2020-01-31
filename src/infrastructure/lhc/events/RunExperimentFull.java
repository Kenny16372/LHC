package infrastructure.lhc.events;

import infrastructure.security.ControlCenter;

import javax.naming.ldap.Control;

public class RunExperimentFull{
    public final int initialEnergy;
    public final ControlCenter controlCenter;
    public RunExperimentFull(int initialEnergy, ControlCenter controlCenter){
        this.controlCenter = controlCenter;
        this.initialEnergy = initialEnergy;
    }
}
