package pl.coderslab.sport_book.model.betting;

import com.sun.org.apache.xpath.internal.operations.Div;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.sport_book.model.Country;
import pl.coderslab.sport_book.model.FootballLeague;
import pl.coderslab.sport_book.model.SportCategory;
import pl.coderslab.sport_book.model.Team;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table (name="fixtures")
public class Fixture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @ManyToOne
    private Country country;

    @NotEmpty
    @OneToOne
    private SportCategory category;

    @NotEmpty
    @OneToOne
    private FootballLeague league;

    @NotEmpty
    private Integer matchday;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date Date;

    @NotEmpty
    private String betStatus;

    @NotEmpty
    @ManyToOne
    private Team homeTeam;

    @NotEmpty
    @ManyToOne
    private Team awayTeam;

    public FootballLeague getLeague() {
        return league;
    }

    //final time home team goals
    private Integer FTHG;

    //final time away team goals
    private Integer FTAG;

    //final result (H-HomeTeam, A- AwayTeam, D-draw)
    private String FTR;

    //home team half-time goal
    private Integer HTHG;

    //away team half-time goal
    private Integer HTAG;

    //half time result (H-HomeTeam, A- AwayTeam, D-draw)
    private char HTR;

    private String Referee;

    @Column (name = "B365H")
    private BigDecimal betHome;

    @Column (name = "B365D")
    private BigDecimal betDraw;

    @Column (name = "B365A")
    private BigDecimal betAway;

    @Column (name="BbAvLt2.5")
    private BigDecimal GoalsLessThan25;

    @Column (name = "BbAvGt2.5")
    private BigDecimal GoalsMoreThan25;

    public Integer getId() {
        return Id;
    }

    public Country getCountry() {
        return country;
    }

    public SportCategory getCategory() {
        return category;
    }

    public FootballLeague getDivision() {
        return league;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public String getBetStatus() {
        return betStatus;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Integer getFTHG() {
        return FTHG;
    }

    public Integer getFTAG() {
        return FTAG;
    }

    public String getFTR() {
        return FTR;
    }

    public Integer getHTHG() {
        return HTHG;
    }

    public Integer getHTAG() {
        return HTAG;
    }

    public char getHTR() {
        return HTR;
    }

    public String getReferee() {
        return Referee;
    }

    public BigDecimal getBetHome() {
        return betHome;
    }

    public BigDecimal getBetDraw() {
        return betDraw;
    }

    public BigDecimal getBetAway() {
        return betAway;
    }

    public BigDecimal getGoalsLessThan25() {
        return GoalsLessThan25;
    }

    public BigDecimal getGoalsMoreThan25() {
        return GoalsMoreThan25;
    }

    public Integer totalScore(){
        return getFTAG()+getFTHG();
    }
}
