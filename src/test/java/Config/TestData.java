package Config;

import java.util.HashMap;

public class TestData {
    public String  credentials(String key)
    {
        HashMap<String, String> locators = new HashMap<String, String>();
        locators.put("coordinatorEmail", "heimdall+coordinator@science37.com");
        locators.put("dataManagerEmail", "heimdall+datamanager@science37.com");
        locators.put("invalidEmail", "abc@science37.com");
        locators.put("devPassword", "Password123456");
        locators.put("stagePassword", "Password1234567");
        locators.put("invalidPassword", "abc");

        return locators.get(key);
    }
    public String  profileNames(String key)
    {
        HashMap<String, String> locators = new HashMap<String, String>();
        locators.put("coordinator", "Coordinator Heimdall");
        locators.put("DataManager", "Datamanager Heimdall");

        return locators.get(key);
    }
}
