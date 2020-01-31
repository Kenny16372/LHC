package infrastructure.security;

import java.util.ArrayList;
import java.util.Calendar;

public interface IReader {
    void insertIDCard(IROIDCard idCard);
    void removeIDCard();
    String getID();
    Calendar getValidFrom();
    Calendar getValidUntil();
    int[][] getIrisStructure();
    boolean isLocked();
    boolean allowEntry();
}
