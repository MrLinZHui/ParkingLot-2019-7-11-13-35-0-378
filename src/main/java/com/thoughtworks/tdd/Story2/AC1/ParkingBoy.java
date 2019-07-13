package com.thoughtworks.tdd.Story2.AC1;

public class ParkingBoy {
    public Ticket park(ParkingLot parkingLot, Car car) {
        return parkingLot.park(car);
    }

    public Car getCar(ParkingLot parkingLot, Ticket ticket) {
        return parkingLot.getCar(ticket);
    }

    public void recognizedticket(Ticket ticket) {
        if(!ticket.isStatus()){
            System.out.print("Unrecognized parking ticket.\n");
        }
    }
}
