package com.thoughtworks.tdd.Story2.AC1;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
//import static org.fest.assertions.api.Assertions.assertThat;
public class ParkingTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void should_get_a_ticker_when_park_a_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 888888");
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket = parkingBoy.park(parkingLot,car);
        //then
        Assertions.assertNotNull(ticket);
    }
    @Test
    public void should_get_tickers_when_park_cars(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 888888");
        Car car1 = new Car("粤B 888888");
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket = parkingBoy.park(parkingLot,car);
        Ticket ticket1 = parkingBoy.park(parkingLot,car1);
        //then
        Assertions.assertEquals(2,parkingLot.getCarMap().size());
        // Assertions.assertNotNull(ticket.ticketnum);
        // Assertions.assertNotNull(ticket1.ticketnum);
    }
    @Test
    public void should_get_right_car_when_give_a_ticket(){
        //given
        HashMap<String, Car> hashMap = new HashMap<>();
        hashMap.put("num:1",new Car("粤B 99800"));
        hashMap.put("num:2",new Car("粤C 88888"));
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket("num:2");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarMap(hashMap);
        //when
        Car car = parkingBoy.getCar(parkingLot,ticket);
        //then
        Assertions.assertEquals("粤C 88888",car.getCarNum());
    }
    @Test
    public void should_get_null_car_when_give_a_wrong_ticket(){
        //given
        HashMap<String, Car> hashMap = new HashMap<>();
        hashMap.put("num:1",new Car("粤B 99800"));
        hashMap.put("num:2",new Car("粤C 88888"));
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket("num:3");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarMap(hashMap);
        //when
        Car car = parkingBoy.getCar(parkingLot,ticket);
        //then
        Assertions.assertNull(car);
    }
    @Test
    public void should_get_null_car_when_give_null(){
        //given
        HashMap<String, Car> hashMap = new HashMap<>();
        hashMap.put("num:1",new Car("粤B 99800"));
        hashMap.put("num:2",new Car("粤C 88888"));
        ParkingBoy parkingBoy = new ParkingBoy();
       // Ticket ticket = new Ticket("num:3");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarMap(hashMap);
        //when
        Car car = parkingBoy.getCar(parkingLot,null);
        //then
        Assertions.assertNull(car);
    }
    @Test
    public void should_get_null_car_when_give_used_ticket(){
        //given
        HashMap<String, Car> hashMap = new HashMap<>();
        hashMap.put("num:1",new Car("粤B 99800"));
        hashMap.put("num:2",new Car("粤C 88888"));
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket("num:2");
        ticket.setStatus(false);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarMap(hashMap);
        //when
        Car car = parkingBoy.getCar(parkingLot,ticket);
        //then
        Assertions.assertNull(car);;
    }
    @Test
    public void should_get_null_when_capacity_is_full(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 66666");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setActualcapacity(10);
        //when
        Ticket ticket = parkingBoy.park(parkingLot,car);
        //then
        Assertions.assertNull(ticket);
    }
    @Test
    public void should_failed_when_pass_null_car_to_parking_boy(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = null;
        ParkingLot parkingLot = new ParkingLot();
        //when+then
        Assertions.assertThrows(RuntimeException.class, () ->{
            parkingBoy.park(parkingLot,car);
        });
    }
    @Test
    public void should_failed_when_pass_a_passed_car_to_parking_boy(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 666666");
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.park(parkingLot,car);
        //when+then
        Assertions.assertThrows(RuntimeException.class, () ->{
            parkingBoy.park(parkingLot,car);
        });
    }
    @Test
    public void should_response_message_when_give_a_used_ticket(){
        //given
        Customer customer = new Customer( new Ticket("num:2"));
        ParkingBoy parkingBoy = new ParkingBoy();
        customer.getTicket().setStatus(false);
        ParkingLot parkingLot = new ParkingLot();
        //when
        parkingBoy.recognizedticket(customer.getTicket());
//        //then
        Assertions.assertEquals( "Unrecognized parking ticket.\n",systemOut());
//        Assertions.assertEquals("粤C 88888",car.getCarNum());
    }
    @Test
    public void should_response_message_when_do_not_give_a_ticket(){
        //given
        Customer customer = new Customer(null);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        parkingBoy.recognizedticket(customer.getTicket());
//        //then
        Assertions.assertEquals( "Please provide your parking ticket.\n",systemOut());
//        Assertions.assertEquals("粤C 88888",car.getCarNum());
    }
//    @Test
//    public void should_response_message_when_don_not_give_a_ticket(){
//        //given
//        ParkingBoy parkingBoy = new ParkingBoy();
//        ParkingLot parkingLot = new ParkingLot();
//       // parkingLot.setCarMap(hashMap);
//        //when
//        parkingBoy.recognizedticket(null);
//
////        Car car = parkingBoy.getCar(parkingLot,ticket);
////        //then
//        Assertions.assertEquals( "Please provide your parking ticket.\n",systemOut());
////        Assertions.assertEquals("粤C 88888",car.getCarNum());
//    }
    @Test
    public void should_response_message__when_capacity_is_full(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 66666");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setActualcapacity(10);
        //when
        parkingBoy.park(parkingLot,car);
        //then
        Assertions.assertEquals( "Not enough position.\n",systemOut());
    }

    private String systemOut() {
        return outContent.toString();
    }
}
