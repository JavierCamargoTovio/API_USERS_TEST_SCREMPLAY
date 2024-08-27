package co.com.test.users.model.parameters;

import java.util.HashMap;
import java.util.Map;

public class GetParameterModel {
    private static final Map<String, String> parametros = new HashMap<>();

    public GetParameterModel() {
    }

    public static Map<String, String> parametroId(String id) {
        parametros.put(ParameterValueModel.ID.getParametro(), id);
        return parametros;
    }

    public static Map<String, String> parametroPage(String page) {
        parametros.put(ParameterValueModel.PAGE.getParametro(), page);
        return parametros;
    }
}
