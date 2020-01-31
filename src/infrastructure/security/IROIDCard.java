package infrastructure.security;

import java.util.ArrayList;
import java.util.Calendar;

public interface IROIDCard {
    String getID();
    Calendar getValidFrom();
    Calendar getValidUntil();
    int[][] getIrisStructure();
    boolean isLocked();
    String getEncryptedPassword();
    boolean hasPermission(Permission permission);
}
