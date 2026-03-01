import java.util.*;

public class DeviceRegistry {

    private final List<Object> devices = new ArrayList<>();

    public void add(Object device) {
        devices.add(device);
    }

    public <T> T getDevice(Class<T> type) {
        for (Object device : devices) {
            if (type.isInstance(device)) {
                return type.cast(device);
            }
        }
        throw new IllegalStateException("Missing device for: " + type.getSimpleName());
    }
}