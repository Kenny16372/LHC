package infrastructure.security;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Calendar;

public class Writer extends Reader implements IWriter{
    private IIDCard idCard;
    private Touchpad touchpad;

    public Writer(){
        super();
        this.touchpad = new Touchpad();
    }

    public void insertIdCard(IIDCard idCard){
        this.idCard = idCard;
    }

    public void removeIdCard(){
        this.idCard = null;
    }

    public void writeToIdCard(String password, Calendar validFrom, Calendar validUntil, int[][] iris){
        this.idCard.setIrisStructure(iris);
        this.idCard.setValidFrom(validFrom);
        this.idCard.setValidUntil(validUntil);
        this.idCard.setLocked(false);
        try {
            this.idCard.setPassword(password);
        }
        catch(Exception e){
            System.out.println("Error setting Password: " + e);
        }
    }

    public void writeToIdCard(String password, Calendar validFrom, Calendar validUntil, int[][] iris, String fingerprint){
        writeToIdCard(password, validFrom, validUntil, iris);
        ((IIDCardEmployee)this.idCard).setFingerprint(fingerprint);
    }

    public static String md5(String input) {
        byte[] res;
        try {
            byte[] bytesOfMessage = input.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            res = md.digest(bytesOfMessage);

        }
        catch(Exception e){
            System.out.println("Error creating MD5-Hash:");
            e.printStackTrace();
            return "";
        }
        return Arrays.toString(res);
    }

    public void setPassword(){
        System.out.println("Setting a new Password: ");
        String password = this.touchpad.password();
        IEncryption encryption = new AES();
        this.idCard.setPassword(encryption.encrypt(password, Configuration.MASTER_PASSWORD.getMasterPassword()));
    }

    public void setValidUntil(Calendar validUntil){
        this.idCard.setValidUntil(validUntil);
    }

    public void addPermission(Permission permission){
        this.idCard.addPermission(permission);
    }

    public void removePermission(Permission permission){
        this.idCard.removePermission(permission);
    }
}
