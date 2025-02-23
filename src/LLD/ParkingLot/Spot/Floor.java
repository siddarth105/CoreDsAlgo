package LLD.ParkingLot.Spot;

import java.util.Map;
import java.util.Set;

public class Floor {
    private Map<SpotType, Set<Spot>> availableSlotMap;
    private int level;

    public Map<SpotType, Set<Spot>> getAvailableSlotMap() {
        return availableSlotMap;
    }

    public int getLevel() {
        return level;
    }
}
