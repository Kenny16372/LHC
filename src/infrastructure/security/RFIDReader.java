package infrastructure.security;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;

public class RFIDReader extends Reader {
    public RFIDReader() throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
    }

    public void insertIdCard(IRORFIDIDCard idCard) {
        this.idCard = idCard;
    }
}