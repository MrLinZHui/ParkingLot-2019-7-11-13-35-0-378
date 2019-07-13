package com.thoughtworks.tdd.Story6.AC1;

import java.util.ArrayList;

public class ParkingBoy {
    private ArrayList<ParkingLot> parkingLotArrayList;

    public ParkingBoy() {
        this.parkingLotArrayList = new ArrayList<>();
    }

    public ArrayList<ParkingLot> getParkingLotArrayList() {
        return parkingLotArrayList;
    }

    public void setParkingLotArrayList(ArrayList<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
    }

    public Ticket park(ArrayList<ParkingLot> arrayList, Car car) {
//        arrayList.forEach(parkingLot ->{
//            Ticket ticket =parkingLot.park(car);
//            if(ticket!=null){
//                return;
//            }
//        });
        Ticket ticket  = null;
        for(int i = 0;i<arrayList.size();i++){
            ticket= arrayList.get(i).park(car);
            if(ticket!=null){
                break;
            }
        }
        if(ticket==null){
            System.out.print( "Not enough position.\n");
        }
        return ticket;
    }

    public Car getCar(ParkingLot parkingLot, Ticket ticket) {
        return parkingLot.getCar(ticket);
    }

    public void recognizedticket(Ticket ticket) {
        if(ticket==null){
            System.out.print("Please provide your parking ticket.\n");
        }
        else if(!ticket.isStatus()){
            System.out.print("Unrecognized parking ticket.\n");
        }
    }
}
