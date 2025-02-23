package LLD.ParkingLot;

import LLD.ParkingLot.Spot.SpotType;
import LLD.ParkingLot.Vehicle.VehicleType;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Util {
    private static Map<VehicleType, SpotType> typeMapping = new HashMap<>();
    public static Map<String, UUID> vehTicketMapping = new HashMap<>(); //<vehNum, ticketID>

    public static boolean canAccomodate(VehicleType vehicleType, SpotType spotType) {
        if (!typeMapping.isEmpty() && typeMapping.get(vehicleType).equals(spotType)) {
            return true;
        }
        return false;
    }
}
