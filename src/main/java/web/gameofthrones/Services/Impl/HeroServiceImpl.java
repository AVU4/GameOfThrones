package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Repositories.HeroRepository;
import web.gameofthrones.Services.HeroService;
import web.gameofthrones.Services.HouseService;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private HouseService houseService;

    @Override
    public List<Hero> getAllInHouse(String name) {
        return heroRepository.getAllByHouseEquals(houseService.getOneByName(name));
    }

    @Override
    public List<Hero> getAll() {
        return heroRepository.findAll();
    }
}
