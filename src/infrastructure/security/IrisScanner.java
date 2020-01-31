package infrastructure.security;

import hr.IROEmployee;
import hr.IROPerson;

public class IrisScanner {
    public int[][] scanIris(IROPerson person){
        return person.getIris();
    }
}
