package infrastructure.security;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import com.google.common.eventbus.EventBus;
import infrastructure.lhc.Subscriber;

public class ControlCenter {
    private IReader reader;
    private String id;
    private EventBus eventBus;

    public ControlCenter() throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        id = "C01";
        this.reader = new Reader();
        this.eventBus = new EventBus("CC-" + this.id);
    }

    
    public void startExperiement(){
        
    }
    
    public void startExperiment(ExperimentScope scope){
    
    }
    
    public void addSubscriber(Subscriber subscriber){
        this.eventBus.register(subscriber);
    }
}
