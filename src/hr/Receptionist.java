package hr;

import infrastructure.security.IDCard;
import infrastructure.security.Reception;

public class Receptionist extends Employee{
    private Reception reception;

    public Receptionist(){
        super();
    }

    public void createIDCard(IPerson person){
        try{
            IDCard idCard = this.reception.createIDCard(person);
            IDCardManagement.instance.addIDCard(person.getID(), idCard);
        }
        catch (NullPointerException e) {
            System.out.println("Please assign receptionist to a reception before creating an ID Card");
            e.printStackTrace();
        }
    }

    public void setReception(Reception reception){
        this.reception = reception;
    }

    public void removeReception(){
        this.reception = null;
    }
}
