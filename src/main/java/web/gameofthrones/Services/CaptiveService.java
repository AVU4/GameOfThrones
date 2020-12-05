package web.gameofthrones.Services;

import web.gameofthrones.Entities.Captive;

import java.util.List;

public interface CaptiveService {

    List<Captive> getAll();
    List<Captive> getAllInHouse(String house);
}
