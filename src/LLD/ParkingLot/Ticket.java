package LLD.ParkingLot;

import java.util.UUID;

public class Ticket {
    private int inTime;
    private int outTime;
    private UUID id;

    public Ticket(int inTime) {
        this.inTime = inTime;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
