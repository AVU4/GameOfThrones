package web.gameofthrones.Services;

import web.gameofthrones.Entities.Castle;

import java.util.List;

public interface CastleService {

    List<Castle> getAllInHouse(String house);
}
