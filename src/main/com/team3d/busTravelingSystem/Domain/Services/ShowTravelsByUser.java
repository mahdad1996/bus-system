package main.com.team3d.busTravelingSystem.Domain.Services;

import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;
import org.hibernate.query.Query;

import java.util.List;

public interface ShowTravelsByUser {
    List<Travel> Show();
}
