package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.gameofthrones.Entities.Alliance;
import web.gameofthrones.Entities.AllianceMember;
import web.gameofthrones.Services.AllianceMemberService;
import web.gameofthrones.Services.AllianceService;

import java.util.List;

@RestController
public class AllianceMemberController {

    @Autowired
    private AllianceMemberService allianceMemberService;

    @Autowired
    private AllianceService allianceService;

    @GetMapping("/alliances")
    public List<Alliance> getAllAlliances(){
        return allianceService.getAll();
    }

    @GetMapping("/alliancemembers")
    public List<AllianceMember> getAll(){
        return allianceMemberService.getAll();
    }
}
