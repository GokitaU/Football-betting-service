package pl.coderslab.sport_book.model.DTO;

import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.model.Wallet;

public class UserDTO {
    private User user;
    private Wallet wallet;

    public UserDTO() {
        this.user = new User();
        this.wallet=new Wallet();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
