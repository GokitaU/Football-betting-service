package pl.coderslab.sport_book.model.betting;

import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class SingleBet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Fixture event;

    private String placedBet;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    private boolean won;

    private BigDecimal betPrice;

    @ManyToOne
    private BetCoupon coupon;

    public SingleBet() {
    }

    public Long getId() {
        return id;
    }

    public Fixture getEvent() {
        return event;
    }

    public String getPlacedBet() {
        return placedBet;
    }

    public void setPlacedBet(String placedBet) {
        this.placedBet = placedBet;
    }

    public void setCoupon(BetCoupon coupon) {
        this.coupon = coupon;
    }

    public boolean isWon() {
        return won;
    }

    public BigDecimal getBetPrice() {
        return betPrice;
    }

    public void setEvent(Fixture event) {
        this.event = event;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public void setBetPrice(BigDecimal betPrice) {
        this.betPrice = betPrice;
    }

    public BetCoupon getCoupon() {
        return coupon;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleBet singleBet = (SingleBet) o;
        return Objects.equals(event, singleBet.event);
    }

    public boolean checkIfUniqe(List<SingleBet> bets){
        if (bets!=null){
            for( SingleBet b:bets){
                if (this.getEvent().getId()==b.getEvent().getId()){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(event);
    }
}

