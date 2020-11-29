package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Repositories.ArmyRepository;
import web.gameofthrones.Services.ArmyService;

import java.util.List;

@Service
public class ArmyServiceImpl implements ArmyService {

    @Autowired
    private ArmyRepository armyRepository;

    @Override
    public List<Army> getAll() {
        return armyRepository.findAll();
    }
}
