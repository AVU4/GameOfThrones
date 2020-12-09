package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.Battle;
import web.gameofthrones.Repositories.BattleRepository;
import web.gameofthrones.Services.BattleService;

import java.util.List;

@Service
public class BattleServiceImpl implements BattleService {

    @Autowired
    private BattleRepository battleRepository;
    @Override
    public List<Battle> getAll() {
        return battleRepository.findAll();
    }
}
