package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Repositories.HouseRepository;
import web.gameofthrones.Services.HouseService;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public House getOneByName(String name) {
        return houseRepository.getHouseByName(name);
    }

    @Override
    public List<House> getAll() {
        return houseRepository.findAll();
    }
}
