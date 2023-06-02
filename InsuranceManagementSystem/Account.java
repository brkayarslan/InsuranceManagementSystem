package InsuranceManagementSystem;

import java.util.ArrayList;

abstract public class Account implements Comparable<Account> {
    private AuthenticationStatus loginStatus;
    private User user;
    private ArrayList<Insurance> insurances;

    public Account(User user) {
        this.loginStatus = AuthenticationStatus.FAIL;
        this.user = user;
        this.insurances = new ArrayList<>();
    }

    public AuthenticationStatus getLoginStatus(){
        return this.loginStatus;
    }

    public User getUser(){
        return this.user;
    }

    public void login(String email, String password) throws InvalidAuthenticationException{
        if(user.getEmail().equals(email) && user.getPassword().equals(password)){
            loginStatus = AuthenticationStatus.SUCCESS;
        }
        else {
            throw new InvalidAuthenticationException("Geçersiz Kimlik Doğrulama");

        }
    }

    public void addInsurance(Insurance insurance){
        insurances.add(insurance);
    }

    public abstract void showUserInfo();

    @Override
    public int compareTo(Account otherAccount){
        return this.user.getEmail().compareTo(otherAccount.user.getEmail());
    }
    @Override
    public int hashCode() {
        return user.getEmail().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Account)) {
            return false;
        }
        Account otherAccount = (Account) obj;
        return this.user.getEmail().equals(otherAccount.user.getEmail());
    }
}
