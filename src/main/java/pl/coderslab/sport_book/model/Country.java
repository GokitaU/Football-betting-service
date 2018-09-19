package pl.coderslab.sport_book.model;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.sport_book.model.betting.Fixture;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @NotEmpty
    private String countryName;

    @OneToMany (mappedBy = "country")
    private List<Team> teams=new ArrayList<>();

    @OneToMany (mappedBy = "country")
    private List<Fixture> fixtures = new ArrayList<>();

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }
}
