package infrastructure.security;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import com.google.common.eventbus.EventBus;
import infrastructure.lhc.Experiment;
import infrastructure.lhc.Subscriber;
import infrastructure.lhc.events.Analyse;
import infrastructure.lhc.events.RunExperimentFull;
import infrastructure.lhc.events.RunExperimentPartial;

public class ControlCenter {
    private IReader reader;
    private String id;
    private EventBus eventBus;

    public ControlCenter() {
        id = "C01";
        this.reader = new Reader();
        this.eventBus = new EventBus("CC-" + this.id);
    }

    
    public void startExperiment(int initalEnergy){
        eventBus.post(new RunExperimentFull(initalEnergy,this));
    }
    
    public void startExperiment(int inititalEnergy, ExperimentScope scope){
        eventBus.post(new RunExperimentPartial(inititalEnergy, scope, this));
    }

    public void startAnalyse(Experiment experiment){
        eventBus.post(new Analyse(experiment));
    }
    
    public void addSubscriber(Subscriber subscriber){
        this.eventBus.register(subscriber);
    }
}
