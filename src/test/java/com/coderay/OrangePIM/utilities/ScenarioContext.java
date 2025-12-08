package com.coderay.OrangePIM.utilities;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	private static ThreadLocal<Map<String, Object>> scenarioContext = ThreadLocal.withInitial(HashMap::new);

    public void setContext(String key, Object value) {
        scenarioContext.get().put(key, value);
    }

    public static Object getContext(String key) {
        return scenarioContext.get().get(key);
    }
    
    public static String getContextAsString(String key) {
        return String.valueOf(scenarioContext.get().get(key));
    }

    public static Boolean contains(String key) {
        return scenarioContext.get().containsKey(key);
    }

    // Wajib dipanggil di @After untuk bersih-bersih
    public static void clear() {
        scenarioContext.remove();
    }
}
