package co.com.test.users.model.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.test.users.util.constants.ConstantPositionManager.ONE_POSITION;
import static co.com.test.users.util.constants.ConstantPositionManager.ZERO_POSITION;

public class CreateAndUpdateUserData {


    private static Map<String, Object> dataQuery = new HashMap<>();

    public static Map<String, Object> getCreateAndUpdateDataServiceUser() {
        return dataQuery;
    }

    public static void dataCreateAndUpdateServiceWithTheFollowing(List<String> data) {
        Map<String, Object> dataQuery = new HashMap<>();
        dataQuery.put("name", data.get(ZERO_POSITION));
        dataQuery.put("job", data.get(ONE_POSITION));
        CreateAndUpdateUserData.dataQuery = dataQuery;
    }
}
