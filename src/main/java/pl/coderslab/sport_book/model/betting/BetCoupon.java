package pl.coderslab.sport_book.model.betting;

import pl.coderslab.sport_book.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BetCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @OneToMany (mappedBy = "coupon")
    private List<SingleBet> bets;

    public void addBet(SingleBet bet){
        this.bets.add(bet);
    }

    @NotNull
    private BigDecimal betValue;

    private BigDecimal winValue;


    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @ManyToOne
    private User user;

    private boolean isWon;


    public BetCoupon() {
        this.bets=new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public List<SingleBet> getBets() {
        return bets;
    }

    public BigDecimal getBetValue() {
        return betValue;
    }

    public BigDecimal getWinValue() {
        return winValue;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public User getUser() {
        return user;
    }

    public boolean getIsWon() {
        return isWon;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBets(List<SingleBet> bets) {
        this.bets = bets;
    }

    public void setBetValue(BigDecimal betValue) {
        this.betValue = betValue;
    }

    public void setWinValue(BigDecimal winValue) {
        this.winValue = winValue;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSuccessful(boolean isWon) {
        this.isWon = isWon;
    }
}
