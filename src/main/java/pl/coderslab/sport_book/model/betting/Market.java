package pl.coderslab.sport_book.model.betting;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Market {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

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
    private String HTR;

    @Transient
    private Integer totalScore;

    public Integer getId() {
        return id;
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

    public String getHTR() {
        return HTR;
    }


    public Market() {
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public Integer totalScore(){
        return getFTAG()+FTHG;

    };

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

    public void setHTR(String HTR) {
        this.HTR = HTR;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}


