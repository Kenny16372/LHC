package infrastructure.security;

import hr.IROPerson;
import hr.Receptionist;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import static java.util.Calendar.YEAR;

public class Reception {
    private List<Receptionist> staff;
    private Stack<IDCard> idCardStack;
    private Touchpad touchpad;
    private IWriter writer;
    private IrisScanner irisScanner;

    public Reception() {
        this.staff = new ArrayList<>();
        this.touchpad = new Touchpad();
        this.writer = new Writer();
        this.irisScanner = new IrisScanner();
        this.idCardStack = new Stack<>();
        for(int i = 0; i < 20; i++) {
            this.idCardStack.push(new IDCard());
        }
    }

    public IDCard createIDCard(IROPerson person) {
        IDCard idCard = idCardStack.pop();
        String password;
        System.out.println("Please enter a password with 5 alphanumerical characters:");
        Pattern pattern = Pattern.compile("\\w{5}");
        if((password = touchpad.password(pattern)) == null){
            System.out.println("Password creation failed, please try again");
        }
        IEncryption encryption = new AES();
        password = encryption.encrypt(password, Configuration.MASTER_PASSWORD.getMasterPassword());

        Calendar now = Calendar.getInstance();
        Calendar validUntil = Calendar.getInstance();
        validUntil.add(YEAR, 1);

        idCard.addPermission(Permission.Visitor);

        int[][] iris = this.irisScanner.scanIris(person);

        this.writer.insertIdCard(idCard);
        this.writer.writeToIdCard(Writer.md5(password), now, validUntil, iris);
        this.writer.removeIdCard();
        idCard.addPermission(Permission.Visitor);
        return idCard;
    }

    public void addReceptionist(Receptionist receptionist){
        if(!this.staff.contains(receptionist)) {
            this.staff.add(receptionist);
        }
        receptionist.setReception(this);
    }

    public void removeReceptionist(Receptionist receptionist){
        this.staff.remove(receptionist);
    }
}
