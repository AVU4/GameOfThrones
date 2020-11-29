package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.Captive;
import web.gameofthrones.Repositories.CaptiveRepositories;
import web.gameofthrones.Services.CaptiveService;

import java.util.List;

@Service
public class CaptiveServiceImpl implements CaptiveService {

    @Autowired
    private CaptiveRepositories captiveRepositories;


    @Override
    public List<Captive> getAll() {
        return captiveRepositories.findAll();
    }

}