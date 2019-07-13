package com.thoughtworks.tdd.Story6.AC1;

import java.util.ArrayList;

public class ParkingManager extends ParkingBoy{
    private ArrayList<ParkingBoy> parkingBoyArrayList;
    private ArrayList<ParkingLot> parkingLotArrayList;
    public ParkingManager() {
        parkingBoyArrayList = new ArrayList<>();
        parkingLotArrayList = new ArrayList<>();
        parkingBoyArrayList.add(this);
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        this.parkingBoyArrayList.add(parkingBoy);
    }

    public ArrayList<ParkingBoy> getParkingBoyArrayList() {
        return parkingBoyArrayList;
    }

    public void setParkingBoyArrayList(ArrayList<ParkingBoy> parkingBoyArrayList) {
        this.parkingBoyArrayList = parkingBoyArrayList;
    }

    public ArrayList<ParkingLot> getParkingLotArrayList() {
        return parkingLotArrayList;
    }

    public void setParkingLotArrayList(ArrayList<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
    }
}
