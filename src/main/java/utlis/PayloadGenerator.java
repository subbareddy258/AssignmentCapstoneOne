package utlis;

import org.json.JSONObject;

public class PayloadGenerator {
    String payload;

    public JSONObject testRequestBody(String test)
    {
        JSONObject testReqBody =  new JSONObject();
        testReqBody.put("test",test);
        return testReqBody;
    }
    public static JSONObject token()
    {
        JSONObject requestParams =  new JSONObject();
        requestParams.put("password", "password123");
        requestParams.put("username", "admin");
        return requestParams;
    }
    public static JSONObject userCreate()
    {
        JSONObject userCreate =  new JSONObject();
        userCreate.put("password", "Test@@123");
        userCreate.put("userName", Utils.generateGuid());
        return userCreate;

    }

    public static JSONObject accountRegistration()
    {
        JSONObject accountRegistration =  new JSONObject();
        accountRegistration.put("name", "Tester");
        accountRegistration.put("email", "testing98@yahpo.com");
        accountRegistration.put("password", "1234567");
        return accountRegistration;

    }
    public static JSONObject shopLogin()
    {
        JSONObject shopLogin =  new JSONObject();
        shopLogin.put("email", "testing99875jruurugggd@o.com");
        shopLogin.put("password", "1234567");
        return shopLogin;

    }
}
