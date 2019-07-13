package com.thoughtworks.tdd.Story1.AC2;

public class Ticket {
    public String ticketnum;
    static int num = 1;
    public Ticket() {
        this.ticketnum = "num:" + num;
        num ++;
    }
}
