package co.com.test.users.util.token;

import org.json.JSONObject;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DecodeUtokenJWT {

   private static final Logger logger = Logger.getLogger(DecodeUtokenJWT.class.getName());
    public static String decodeToken(String uToken){
        String[] parts = uToken.split("\\.");
        String signature = decode(parts[1]);
        logger.log(Level.INFO, signature);
        JSONObject json = new JSONObject(signature);
        String idToken = json.getString("idToken");
        logger.log(Level.INFO, idToken);
        return idToken;
    }

    private static String decode(String encodedString) {
        return new String(Base64.getUrlDecoder().decode(encodedString));
    }

}
