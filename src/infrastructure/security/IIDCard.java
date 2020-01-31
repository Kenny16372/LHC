package infrastructure.security;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public interface IIDCard extends IROIDCard{
    void setValidFrom(Calendar validFrom);
    void setValidUntil(Calendar validUntil);
    void setIrisStructure(int[][] irisStructure);
    void addPermission(Permission permission);
    void setLocked(boolean locked);
    void setPassword(String newPassword);
    void removePermission(Permission permission);
}
