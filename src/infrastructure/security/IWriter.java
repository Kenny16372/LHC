package infrastructure.security;

import java.util.Calendar;

public interface IWriter extends IReader{
    void insertIdCard(IIDCard idCard);
    void removeIdCard();
    void writeToIdCard(String password, Calendar validFrom, Calendar validUntil, int[][] iris);
    void writeToIdCard(String password, Calendar validFrom, Calendar validUntil, int[][] iris, String fingerprint);
    void setPassword();
    void setValidUntil(Calendar validUntil);
    void addPermission(Permission permission);
    void removePermission(Permission permission);
}
