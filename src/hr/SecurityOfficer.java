package hr;

import hr.Employee;
import infrastructure.security.IDCard;
import infrastructure.security.IIDCard;
import infrastructure.security.SecurityCentre;

public class SecurityOfficer extends Employee {
    private boolean hasWeapon;
    private SecurityCentre securityCentre;

    public boolean hasWeapon() {
        return hasWeapon;
    }

    public void setWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    public SecurityOfficer(){
        super();
    }

    public SecurityCentre getSecurityCentre() {
        return securityCentre;
    }

    public void setSecurityCentre(SecurityCentre securityCentre) {
        if(this.securityCentre != securityCentre) {
            this.securityCentre = securityCentre;
            securityCentre.addOfficer(this);
        }
    }

    public IDCard createIDCard(Employee employee){
        return this.securityCentre.createIdCard(employee);
    }

    public void lock(IIDCard idCard){
        this.securityCentre.lock(idCard);
    }

    public void unlock(IIDCard idCard){
        this.securityCentre.unlock(idCard);
    }
}
