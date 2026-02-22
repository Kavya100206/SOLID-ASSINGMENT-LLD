import java.util.*;

public class PricingRegistry {

    private static final Map<Integer, RoomPricing> roomMap = new HashMap<>();
    private static final Map<AddOn, AddOnPricing> addOnMap = new HashMap<>();

    static {
        // room pricing
        roomMap.put(LegacyRoomTypes.SINGLE, new SingleRoomPricing());
        roomMap.put(LegacyRoomTypes.DOUBLE, new DoubleRoomPricing());
        roomMap.put(LegacyRoomTypes.TRIPLE, new TripleRoomPricing());

        // add-on pricing
        addOnMap.put(AddOn.MESS, new MessAddOnPricing());
        addOnMap.put(AddOn.LAUNDRY, new LaundryAddOnPricing());
        addOnMap.put(AddOn.GYM, new GymAddOnPricing());
    }

    public static RoomPricing getRoomPricing(int roomType) {
        return roomMap.getOrDefault(roomType, new DoubleRoomPricing());
    }

    public static AddOnPricing getAddOnPricing(AddOn addOn) {
        return addOnMap.get(addOn);
    }
}