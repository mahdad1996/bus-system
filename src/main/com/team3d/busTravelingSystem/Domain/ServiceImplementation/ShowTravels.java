package main.com.team3d.busTravelingSystem.Domain.ServiceImplementation;

import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.TravelRepository;

import java.util.List;

public class ShowTravels implements main.com.team3d.busTravelingSystem.Domain.Services.ShowTravels {
    @Override
    public List<Travel> show() {
        TravelRepository travelRepository = TravelRepository.getInstance();
        return travelRepository.findAll();
    }
}
