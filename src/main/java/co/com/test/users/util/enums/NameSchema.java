package co.com.test.users.util.enums;

public enum NameSchema {
    GET_USER_ID("GetUserId"),
    GET_USERS_LIST("GetUsersList");


    private final String nameSchema;
    NameSchema(String nameSchema) {
        this.nameSchema = nameSchema;
    }

    public String getNameSchema() {
        return nameSchema;
    }
}
