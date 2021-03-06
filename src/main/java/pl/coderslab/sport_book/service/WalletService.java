package pl.coderslab.sport_book.service;

import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.model.Wallet;

public interface WalletService {

    void saveWallet(Wallet wallet);
    Wallet findByOwner(User user);
}
