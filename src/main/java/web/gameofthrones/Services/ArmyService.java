package web.gameofthrones.Services;

import web.gameofthrones.Entities.Army;

import java.util.List;

public interface ArmyService {

    List<Army> getAll();
    List<Army> getAllInHouse(String house);
}
