package hr;

import infrastructure.security.IROIDCard;

public interface IROEmployee {
    IROIDCard getIdCard();
    boolean isManager();
    boolean isMentor();
    boolean hasBudgetResponsibility();
}
