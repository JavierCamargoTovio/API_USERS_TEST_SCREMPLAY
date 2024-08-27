package co.com.test.users.model.headers;

import java.util.HashMap;
import java.util.Map;

public class GetHeaderModel {
    private static final Map<String, String> headers = new HashMap<>();

    private GetHeaderModel() {
    }

    public static Map<String, String> headersDefault() {
        headers.put(HeaderValueModel.CONTENT_TYPE.getHeader(), HeaderValueModel.CONTENT_TYPE.getValue());
        headers.put(HeaderValueModel.ACCEPT.getHeader(), HeaderValueModel.ACCEPT.getValue());
        return headers;
    }

}
