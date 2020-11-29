package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.gameofthrones.Entities.Alliance;
import web.gameofthrones.Entities.AllianceMember;
import web.gameofthrones.Entities.MemberBattle;
import web.gameofthrones.Services.AllianceMemberService;
import web.gameofthrones.Services.AllianceService;
import web.gameofthrones.Services.MemberBattleService;

import java.util.List;

@RestController
public class AllianceMemberController {

    @Autowired
    private AllianceMemberService allianceMemberService;

    @Autowired
    private AllianceService allianceService;

    @Autowired
    private MemberBattleService memberBattleService;

    @GetMapping("/alliances")
    public List<Alliance> getAllAlliances(){
        return allianceService.getAll();
    }

    @GetMapping("/alliancemembers")
    public List<AllianceMember> getAll(){
        return allianceMemberService.getAll();
    }

    @GetMapping("/battlemembers")
    public List<MemberBattle> getAllBattleMembers(){return memberBattleService.getAll(); }
}
