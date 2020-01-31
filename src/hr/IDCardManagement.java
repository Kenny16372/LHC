package hr;

import infrastructure.security.IDCard;

import java.util.HashMap;
import java.util.Map;

public enum IDCardManagement {
    instance;
    public Map<Integer, IDCard> idCardMap;

    public IDCard getIDCard(Integer id){
        return idCardMap.get(id);
    }

    public void addIDCard(Integer id, IDCard idCard){
        if(idCardMap == null){
            idCardMap = new HashMap<>();
        }
        idCardMap.put(id, idCard);
    }

    public void removeIDCard(Integer id){
        idCardMap.remove(id);
    }
}
