package co.com.test.users.model.parameters;

public enum ParameterValueModel {

    ID("id"),
    PAGE("page");
    private String parametro;


    ParameterValueModel(String parametro) {
        this.parametro = parametro;

    }

    public String getParametro() {
        return parametro;
    }


}
