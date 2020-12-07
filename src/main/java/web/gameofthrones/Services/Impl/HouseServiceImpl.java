package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Repositories.HouseRepository;
import web.gameofthrones.Services.HeroService;
import web.gameofthrones.Services.HouseService;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private HeroService heroService;

    @Override
    public House getOneByName(String name) {
        return houseRepository.getHouseByName(name);
    }

    @Override
    public List<House> getAll() {
        return houseRepository.findAll();
    }

    @Override
    public House getOneByHeroName(String name) {
        return houseRepository.getHouseByHeroesEquals(heroService.getByName(name));
    }

    @Override
    public void setGold(String house, long golds) {
        houseRepository.setGold(house, golds);
    }


}
