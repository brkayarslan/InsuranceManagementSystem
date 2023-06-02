package InsuranceManagementSystem;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accounts;

    public AccountManager() {
        this.accounts = new ArrayList<>();
    }

    public void registerAccount(Account account){
        this.accounts.add(account);
    }

    public Account login(String email, String password) throws InvalidAuthenticationException {
        for (Account account : accounts) {
            if (account.getUser().getEmail().equals(email)) {
                account.login(email, password);
                return account;
            }
        }
        throw new InvalidAuthenticationException("Hesap bulunamadı");
    }

}
