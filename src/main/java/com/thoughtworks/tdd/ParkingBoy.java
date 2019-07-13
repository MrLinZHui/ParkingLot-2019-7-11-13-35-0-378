package com.thoughtworks.tdd;

public class ParkingBoy {
    public Ticket park(ParkingLot parkingLot, Car car) {
        return parkingLot.getTicket(car);
    }

    public Car getCar(ParkingLot parkingLot, Ticket ticket) {
        return parkingLot.getCar(ticket);
    }
}
