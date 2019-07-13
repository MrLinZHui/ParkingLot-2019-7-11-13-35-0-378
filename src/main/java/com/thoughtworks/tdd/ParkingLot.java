package com.thoughtworks.tdd;

public class ParkingLot {
    public Ticket getTicket(Car car) {
        return new Ticket();
    }

    public Car getCar(Ticket ticket) {
        return new Car();
    }
}
