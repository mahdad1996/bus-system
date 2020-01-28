package main.com.team3d.busTravelingSystem.Persistent.Repositories;

import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;

public class TicketRepository extends CrudRepository<Travel,Long> {


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
    protected Class<Travel> getEntityClass() {
        return Travel.class;
    }
}
