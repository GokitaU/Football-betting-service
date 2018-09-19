package pl.coderslab.sport_book.model.betting;

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
}
