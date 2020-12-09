package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.Captive;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Repositories.CaptiveRepositories;
import web.gameofthrones.Services.CaptiveService;
import web.gameofthrones.Services.HouseService;

import java.util.List;

@Service
public class CaptiveServiceImpl implements CaptiveService {

    @Autowired
    private CaptiveRepositories captiveRepositories;

    @Autowired
    private HouseService houseService;


    @Override
    public List<Captive> getAll() {
        return captiveRepositories.findAll();
    }

    @Override
    public List<Captive> getAllInHouse(String house) {
        return captiveRepositories.findAllByHouseOwner_Name(house);
    }

    @Override
    public List<Captive> getAllFromOtherHouse(String house) {
        return captiveRepositories.findAllByHero_House_NameAndHouseOwnerIsNot(house, houseService.getOneByName(house));
    }

    @Override
    public long deleteCaptive(String name) {
        return captiveRepositories.deleteCaptiveByHero_Name(name);
    }

}
