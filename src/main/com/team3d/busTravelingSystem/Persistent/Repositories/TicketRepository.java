package main.com.team3d.busTravelingSystem.Persistent.Repositories;

import main.com.team3d.busTravelingSystem.Persistent.Models.Ticket;

public class TicketRepository extends CrudRepository<Ticket,Long> {


    private static TicketRepository ticketRepository;

    private TicketRepository() {

    }

    public static TicketRepository getInstance() {
        if (ticketRepository == null) {
            ticketRepository = new TicketRepository();
        }
        return ticketRepository;
    }



    @Override
    protected Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}
