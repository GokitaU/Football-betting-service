package pl.coderslab.sport_book.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class FootballLeague {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String name;


    private int division;

    public FootballLeague(String name, int division) {
        this.name = name;
        this.division = division;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDivision() {
        return division;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public FootballLeague() {
    }
}
