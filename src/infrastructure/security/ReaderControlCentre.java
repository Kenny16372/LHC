package infrastructure.security;

import hr.IROPerson;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ReaderControlCentre extends Reader{
    private IrisScanner irisScanner;

    public ReaderControlCentre() throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        super();
        this.irisScanner = new IrisScanner();
    }
    public boolean allowEntryControlCentre(IROPerson person){
        if(allowEntry()){
            int[][] iris = irisScanner.scanIris(person);
            if(Arrays.deepEquals(iris, this.idCard.getIrisStructure())){
                return true;
            }
        }
        return false;
    }
}
