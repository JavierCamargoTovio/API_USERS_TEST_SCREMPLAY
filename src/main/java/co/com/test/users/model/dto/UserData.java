package co.com.test.users.model.dto;

import co.com.test.users.util.constants.ConstantPositionManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserData {

    public static Map<String, Object> dataQuery;


    public static Map<String, Object> getDataServiceUser() {
        return dataQuery;
    }

    public static void consultServiceWithTheFollowingData(List<String> data) {
        Map<String, Object> dataQuery = new HashMap<>();
        dataQuery.put("id", data.get(ConstantPositionManager.ZERO_POSITION));
        dataQuery.put("email", data.get(ConstantPositionManager.ONE_POSITION));
        dataQuery.put("first_name", data.get(ConstantPositionManager.TWO_POSITION));
        dataQuery.put("last_name", data.get(ConstantPositionManager.THREE_POSITION));
        dataQuery.put("avatar", data.get(ConstantPositionManager.FOUR_POSITION));
        UserData.dataQuery = dataQuery;
    }
}
