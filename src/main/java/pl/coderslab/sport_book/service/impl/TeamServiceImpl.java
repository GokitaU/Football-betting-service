package pl.coderslab.sport_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.Team;
import pl.coderslab.sport_book.repository.TeamRepository;
import pl.coderslab.sport_book.service.TeamService;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;


    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();

    }
}
