package LLD.ParkingLot;

import LLD.ParkingLot.Spot.Floor;
import LLD.ParkingLot.Spot.Spot;
import LLD.ParkingLot.Spot.SpotType;
import LLD.ParkingLot.Vehicle.Vehicle;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class DriverClass {

    Map<Integer, Floor> parkingSpace;

    private Spot getAvailableSpot(Vehicle veh) {
        Spot spot = null;
        parkingSpace.forEach((lvl,floor) -> {
            Set<Spot> largeSpot = floor.getAvailableSlotMap().get(SpotType.LARGE);
            //get the type of slot as per the vehicle type
        });
        return spot;
    }

    private void enter(Vehicle veh) {
        Spot spot = getAvailableSpot(veh);
        int currentTime = 0;
        Ticket tkt =  new Ticket(currentTime);
        Util.vehTicketMapping.put(veh.getRegNum(),tkt.getId());
    }

    private void exit(Vehicle veh) {
        UUID tktId = Util.vehTicketMapping.get(veh.getRegNum());
        // Calculate payment using Util.paymentChargesMap
        // & adding out time
        Util.vehTicketMapping.remove(veh.getRegNum());
        //Spot spot = getSpot(veh.getRegNum());
        //spot.removeVehicle()
    }

    public static void main(String args) {

    }
}
