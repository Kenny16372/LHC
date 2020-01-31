package infrastructure.security;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface IEncryption {
    String encrypt(String data, String key);
    String decrypt(String data, String key);
}
