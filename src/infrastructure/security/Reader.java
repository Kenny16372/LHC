package infrastructure.security;

import java.util.ArrayList;
import java.util.Calendar;

public class Reader implements IReader{
    IROIDCard idCard;
    private Touchpad touchpad;
    private static String encryptedInitialPassword;

    public void insertIDCard(IROIDCard idCard){
        this.idCard = idCard;
    }

    public void removeIDCard(){
        this.idCard = null;
    }

    public Reader() {
        this.touchpad = new Touchpad();
        if(Reader.encryptedInitialPassword == null){
            IEncryption encryption = new AES();
            String initialPassword = "helloLHC2020";
            Reader.encryptedInitialPassword = encryption.encrypt(initialPassword, Configuration.MASTER_PASSWORD.getMasterPassword());
        }
    }

    public String getID(){
        return this.idCard.getID();
    }
    public Calendar getValidFrom(){
        return this.idCard.getValidFrom();
    }
    public Calendar getValidUntil(){
        return this.idCard.getValidUntil();
    }
    public int[][] getIrisStructure(){
        return this.idCard.getIrisStructure();
    }
    public boolean isLocked(){
        return this.idCard.isLocked();
    }

    public boolean allowEntry(){
        try {
            if (this.idCard.isLocked()){
                System.out.println("This ID Card is locked");
                return false;
            }
            if(this.idCard.hasPermission(Permission.Visitor)){
                System.out.println("Visitors not allowed beyond this point");
                return false;
            }
            if(this.idCard.getEncryptedPassword().compareTo(Reader.encryptedInitialPassword) == 0){
                System.out.println("Please reset your password before first use");
                return false;
            }
            if(this.idCard.getValidUntil().compareTo(Calendar.getInstance()) < 1){
                System.out.println("This ID Card has expired");
                return false;
            }
            System.out.println("Please enter your password:");
            String password = getPassword();
            String storedPassword = this.idCard.getEncryptedPassword();
            if(password.compareTo(storedPassword) != 0){
                System.out.println("Wrong password. Please try again");
                return false;
            }
            return true;
        }
        catch (Exception e){
            System.out.println("Please insert an ID Card");
        }
        return false;
    }

    private String getPassword(){
        IEncryption encryption = new AES();
        return encryption.encrypt(this.touchpad.password(), Configuration.MASTER_PASSWORD.getMasterPassword());
    }
}
