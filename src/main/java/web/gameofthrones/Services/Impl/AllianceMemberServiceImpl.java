package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.AllianceMember;
import web.gameofthrones.Repositories.AllianceMemberRepository;
import web.gameofthrones.Services.AllianceMemberService;

import java.util.List;

@Service
public class AllianceMemberServiceImpl implements AllianceMemberService {

    @Autowired
    private AllianceMemberRepository allianceMemberRepository;

    @Override
    public List<AllianceMember> getAll() {
        return allianceMemberRepository.findAll();
    }
}
