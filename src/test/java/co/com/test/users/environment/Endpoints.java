package co.com.test.users.environment;


import co.com.test.users.stepdefinitions.Hook;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;

public class Endpoints {

        public static final String BASE_URL = setEndpoint("baseUrl");
        public static final String AUTH = setEndpoint("auth");
        public static final String GET_ALL_USERS = setEndpoint("getAllUsers");
        public static final String GET_USER_BY_ID = setEndpoint("getUserId");
        public static final String CREATE_USER= setEndpoint("createUser");
        public static final String UPDATE_USER= setEndpoint("updateUser");

        private Endpoints() {
            //Nothing
        }
        public static String setEndpoint(String path) {
                return EnvironmentSpecificConfiguration.from(Hook.environmentVariables).getProperty(path);
        }

}
