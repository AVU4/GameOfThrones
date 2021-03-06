package web.gameofthrones.Services;

import web.gameofthrones.Entities.House;

import java.util.List;

public interface HouseService {

    House getOneByName(String name);
    List<House> getAll();
    House getOneByHeroName(String name);
    void setGold(String house, long golds);
    void refresh(House house);
}
