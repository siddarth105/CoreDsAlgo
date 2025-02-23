package LLD.ParkingLot.Vehicle;

public abstract class Vehicle {
    private String regNum;
    private VehicleType vehType;

    public Vehicle(String regNum, VehicleType vehType) {
        this.regNum = regNum;
        this.vehType = vehType;
    }

    public String getRegNum() {
        return regNum;
    }

    public VehicleType getVehType() {
        return vehType;
    }
}
