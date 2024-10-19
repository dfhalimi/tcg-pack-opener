package Application;

import java.util.HashMap;
import java.util.Map;

public class SimpleDIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    // Register an instance manually (useful for external dependencies or singletons)
    public <T> void registerInstance(Class<T> clazz, T instance) {
        instances.put(clazz, instance);
    }

    // Get an instance of a class
    public <T> T getInstance(Class<T> clazz) {
        try {
            // Check if an instance already exists
            if (instances.containsKey(clazz)) {
                return clazz.cast(instances.get(clazz));
            }

            // Create a new instance if not found
            T newInstance = createInstance(clazz);
            instances.put(clazz, newInstance);
            return newInstance;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of: " + clazz, e);
        }
    }

    // Create an instance and handle dependencies
    private <T> T createInstance(Class<T> clazz) throws Exception {
        // Find the constructor (assumes only one constructor)
        var constructor = clazz.getConstructors()[0];
        var parameterTypes = constructor.getParameterTypes();

        // Recursively get instances of the constructor's parameters
        Object[] parameters = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            parameters[i] = getInstance(parameterTypes[i]);
        }

        // Create a new instance with the resolved dependencies
        return clazz.cast(constructor.newInstance(parameters));
    }
}
