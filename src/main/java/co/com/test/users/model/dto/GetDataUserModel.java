package co.com.test.users.model.dto;


import java.util.Map;

public class GetDataUserModel {


    public static String getDataFieldsUserModel(Map<String, Object> dataQuery, String valor){
        return dataQuery.get(valor).toString();
    }
}
