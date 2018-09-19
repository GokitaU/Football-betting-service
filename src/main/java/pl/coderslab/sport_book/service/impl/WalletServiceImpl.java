package pl.coderslab.sport_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.model.Wallet;
import pl.coderslab.sport_book.repository.WalletRepository;
import pl.coderslab.sport_book.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    WalletRepository walletRepository;

    public  void saveWallet(Wallet wallet){
        walletRepository.save(wallet);
    }

    @Override
    public Wallet findByOwner(User user) {
        return walletRepository.findByOwner(user);
    }
}
