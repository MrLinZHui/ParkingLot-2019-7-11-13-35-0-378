package com.thoughtworks.tdd.Story1.AC2;

public class Ticket {
    private String ticketnum;
    static int num = 1;
    public Ticket() {
        this.ticketnum = "num:" + num;
        num ++;
    }

    public Ticket(String ticketnum) {
        this.ticketnum = ticketnum;
    }

    public String getTicketnum() {
        return ticketnum;
    }

    public void setTicketnum(String ticketnum) {
        this.ticketnum = ticketnum;
    }

    @Override
    public boolean equals(Object obj) {
        Ticket ticket = (Ticket)obj;
        if(this.ticketnum ==((Ticket) obj).getTicketnum()){
            return true;
        }
        return false;
    }
}
