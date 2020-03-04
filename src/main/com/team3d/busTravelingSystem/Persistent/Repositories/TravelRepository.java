package main.com.team3d.busTravelingSystem.Persistent.Repositories;

import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;

public class TravelRepository extends CrudRepository<Travel,Long> {


    private static TravelRepository travelRepository;

    private TravelRepository() {

    }

    public static TravelRepository getInstance() {
        if (travelRepository == null) {
            travelRepository = new TravelRepository();
        }
        return travelRepository;
    }


    @Override
    protected Class<Travel> getEntityClass() {
        return Travel.class;
    }
}
