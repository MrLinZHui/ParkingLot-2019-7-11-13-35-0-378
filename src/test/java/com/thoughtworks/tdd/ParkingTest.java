package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingTest {
    @Test
    public void should_get_ticker_when_park_a_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket = parkingBoy.park(parkingLot,car);
        //then
        Assertions.assertNotNull(ticket);
    }
}
