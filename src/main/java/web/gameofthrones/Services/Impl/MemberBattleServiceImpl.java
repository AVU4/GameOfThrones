package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.MemberBattle;
import web.gameofthrones.Repositories.MemberBattleRepository;
import web.gameofthrones.Services.MemberBattleService;

import java.util.List;

@Service
public class MemberBattleServiceImpl implements MemberBattleService {

    @Autowired
    private MemberBattleRepository memberBattleRepository;


    @Override
    public List<MemberBattle> getAll() {
        return memberBattleRepository.findAll();
    }
}
