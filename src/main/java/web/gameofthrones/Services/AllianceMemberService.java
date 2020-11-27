package web.gameofthrones.Services;

import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.AllianceMember;

import java.util.List;


public interface AllianceMemberService {

    List<AllianceMember> getAll();
}
