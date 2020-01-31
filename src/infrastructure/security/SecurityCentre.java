package infrastructure.security;

import hr.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import static java.util.Calendar.YEAR;

public class SecurityCentre {
    private List<SecurityOfficer> staff;
    private IWriter writer;

    public IDCardEmployee createIdCard(IROPerson person) {
        IDCardEmployee idCard = new IDCardEmployee();
        String password = "helloLHC2020";
        IEncryption encryption = new AES();
        password = encryption.encrypt(password, Configuration.MASTER_PASSWORD.getMasterPassword());
        Calendar now = Calendar.getInstance();
        Permission permission = getPermission();
        idCard.addPermission(permission);
        idCard.setFingerprint(Writer.md5(person.getName()));
        Calendar validUntil = Calendar.getInstance();
        validUntil.add(YEAR, 1);
        String fingerprint = Writer.md5(person.getName());
        int[][] iris = person.getIris();

        this.writer.insertIdCard(idCard);
        this.writer.writeToIdCard(password, now, validUntil, iris, fingerprint);
        this.writer.removeIdCard();
        IDCardManagement.instance.addIDCard(person.getID(), idCard);
        EmployeeManagement.instance.addEmployee(person.getID(), (Employee)person);
        return idCard;
    }

    public SecurityCentre() {
        this.writer = new Writer();
        this.staff = new ArrayList<>();
    }

    public void lock(IIDCard idCard){
        idCard.setLocked(true);
    }

    public void unlock(IIDCard idCard){
        idCard.setLocked(false);
    }

    public void addOfficer(SecurityOfficer securityOfficer){
        if(!this.staff.contains(securityOfficer)){
            this.staff.add(securityOfficer);
            securityOfficer.setSecurityCentre(this);
        }
    }

    private Permission getPermission() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Select the type of permission for the ID Card: (R)esearcher, (C)ontrol Center or (S)ecurity:");
            switch (scan.next().toUpperCase().charAt(0)) {
                case 'R':
                    return Permission.Researcher;
                case 'C':
                    return Permission.ControlCenter;
                case 'S':
                    return Permission.Security;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
