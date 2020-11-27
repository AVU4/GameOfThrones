package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.Alliance;
import web.gameofthrones.Repositories.AllianceRepository;
import web.gameofthrones.Services.AllianceService;

import java.util.List;

@Service
public class AllianceServiceImpl implements AllianceService {

    @Autowired
    private AllianceRepository allianceRepository;

    @Override
    public List<Alliance> getAll() {
        return allianceRepository.findAll();
    }
}
