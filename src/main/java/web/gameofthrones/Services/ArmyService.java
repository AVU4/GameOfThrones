package web.gameofthrones.Services;

import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.Squad;

import java.util.List;

public interface ArmyService {

    List<Army> getAll();
    List<Army> getAllInHouse(String house);
    Army getOneById(long id);
    Squad addSquad(Squad squad);
    Squad getSquad(long id);
    void refresh(Army army);
    void refreshSquad(Squad squad);
    Army addArmy(Army army);
}
