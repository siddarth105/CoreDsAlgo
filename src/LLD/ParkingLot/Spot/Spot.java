package LLD.ParkingLot.Spot;

import LLD.ParkingLot.InvalidSpotAllocationException;
import LLD.ParkingLot.Util;
import LLD.ParkingLot.Vehicle.Vehicle;

import java.util.Objects;

public abstract class Spot {
    private Location loc;
    private Vehicle veh;
    private SpotType spotType;

    public Spot(Location loc, SpotType spotType) {
        this.loc = loc;
        this.spotType = spotType;
    }

    public void addVehicle(Vehicle veh) throws InvalidSpotAllocationException{
        if (isEmpty() && Util.canAccomodate(veh.getVehType(), spotType)) {
            this.veh = veh;
        } else {
            throw new InvalidSpotAllocationException();
        }
    }

    public Vehicle removeVehicle() {
        Vehicle local = this.veh;
        this.veh = null;
        return local;
    }

    public boolean isEmpty() {
        return Objects.isNull(veh);
    }
}
