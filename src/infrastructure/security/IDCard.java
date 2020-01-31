package infrastructure.security;

import java.util.ArrayList;
import java.util.Calendar;

public class IDCard implements IIDCard, IRORFIDIDCard{
    private final String id;
    private Calendar validFrom;
    private Calendar validUntil;
    private int[][] irisStructure;
    private ArrayList<Permission> permissionList;
    private boolean isLocked;
    protected Chip chip;
    private static long idStatic = 0;

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public Calendar getValidFrom() {
        return this.validFrom;
    }

    @Override
    public Calendar getValidUntil() {
        return this.validUntil;
    }

    @Override
    public int[][] getIrisStructure() {
        return this.irisStructure;
    }

    public String getEncryptedPassword() {
        return chip.getContent();
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public void setValidFrom(Calendar validFrom) {
        this.validFrom = validFrom;
    }

    @Override
    public void setValidUntil(Calendar validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public void setIrisStructure(int[][] irisStructure) {
        this.irisStructure = irisStructure;
    }

    @Override
    public void addPermission(Permission permission) {
        if(!this.permissionList.contains(permission)) {
            this.permissionList.add(permission);
        }
    }

    public boolean hasPermission(Permission permission){
        return this.permissionList.contains(permission);
    }

    @Override
    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public IDCard(){
        this.id = String.valueOf(idStatic++);
        this.permissionList = new ArrayList<>();
        this.chip = new Chip();
    }

    public String RFID(){
        return this.chip.getContent();
    }

    public void setPassword(String newPassword) {
        this.chip.setContent(newPassword);
    }

    public void removePermission(Permission permission){
        this.permissionList.remove(permission);
    }
}
