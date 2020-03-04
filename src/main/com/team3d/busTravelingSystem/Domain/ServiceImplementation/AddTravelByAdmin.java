package main.com.team3d.busTravelingSystem.Domain.ServiceImplementation;

import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.TravelRepository;

public class AddTravelByAdmin implements main.com.team3d.busTravelingSystem.Domain.Services.AddTravelByAdmin {
    @Override
    public void Add(Travel travel) {
        TravelRepository travelRepository = TravelRepository.getInstance();
        travelRepository.save(travel);
    }
}
