package com.univorleans.fr.tp1.services;

import com.univorleans.fr.tp1.domain.IdentityData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentRessourceHardcoded {

    private static List<IdentityData> datas = new ArrayList<>();
    private static long idCounter = 0;

    static {
        datas.add(new IdentityData(++idCounter, "Kone","moussa" ));
    }

    public List<IdentityData> findAll() {
        return datas;
    }

    public IdentityData save(IdentityData identityData) {
        if(identityData.getId()==-1 || identityData.getId()==0) {
            identityData.setId(++idCounter);
            datas.add(identityData);
        } else {
            deleteById(identityData.getId());
            datas.add(identityData);
        }
        return identityData;
    }

    public IdentityData deleteById(long id) {
        IdentityData identityData = findById(id);

        if(identityData==null) return null;

        if(datas.remove(identityData)) {
            return identityData;
        }

        return null;
    }

    public IdentityData findById(long id) {
        for(IdentityData identityData:datas) {
            if(identityData.getId() == id) {
                return identityData;
            }
        }

        return null;
    }

}
