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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setCategory(SportCategory category) {
        this.category = category;
    }

    public void setLeague(FootballLeague league) {
        this.league = league;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public void setBetStatus(String betStatus) {
        this.betStatus = betStatus;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setFTHG(Integer FTHG) {
        this.FTHG = FTHG;
    }

    public void setFTAG(Integer FTAG) {
        this.FTAG = FTAG;
    }

    public void setFTR(String FTR) {
        this.FTR = FTR;
    }

    public void setHTHG(Integer HTHG) {
        this.HTHG = HTHG;
    }

    public void setHTAG(Integer HTAG) {
        this.HTAG = HTAG;
    }

    public void setHTR(char HTR) {
        this.HTR = HTR;
    }

    public void setReferee(String referee) {
        Referee = referee;
    }

    public void setBetHome(BigDecimal betHome) {
        this.betHome = betHome;
    }

    public void setBetDraw(BigDecimal betDraw) {
        this.betDraw = betDraw;
    }

    public void setBetAway(BigDecimal betAway) {
        this.betAway = betAway;
    }

    public void setGoalsLessThan25(BigDecimal goalsLessThan25) {
        GoalsLessThan25 = goalsLessThan25;
    }

    public void setGoalsMoreThan25(BigDecimal goalsMoreThan25) {
        GoalsMoreThan25 = goalsMoreThan25;
    }
}
