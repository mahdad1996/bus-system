package main.com.team3d.busTravelingSystem.Domain;

import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.TravelRepository;
import org.hibernate.query.Query;

import java.util.List;

public class ShowTravelsByUser implements main.com.team3d.busTravelingSystem.Domain.Services.ShowTravelsByUser {
    @Override
    public List<Travel> Show() {

        TravelRepository travelRepository = TravelRepository.getInstance();
        return travelRepository.findAll();
    }
}
