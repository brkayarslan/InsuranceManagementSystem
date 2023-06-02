package InsuranceManagementSystem;

import java.util.Calendar;
import java.util.Date;

import InsuranceManagementSystem.AccountManager;
import InsuranceManagementSystem.Individual;
import InsuranceManagementSystem.User;
import InsuranceManagementSystem.HomeAddress;
import InsuranceManagementSystem.HealthInsurance;
import InsuranceManagementSystem.Enterprise;
import InsuranceManagementSystem.Account;
import InsuranceManagementSystem.InvalidAuthenticationException;

public class Main {
    public static void main(String[] args) {

        // AccountManager oluşturma
        AccountManager accountManager = new AccountManager();

        // Bireysel müşteri hesabı oluşturma
        Individual individualAccount = new Individual(new User("John","Doe","john@example.com","123456","Engineer",23));
        individualAccount.getUser().setAddresses(new HomeAddress("123 Main St.", "New York", "NY", "12345","US"));
        individualAccount.addInsurance(new HealthInsurance("Health Plan",1099.0,new Date(2, Calendar.JULY,2023),new Date(2, Calendar.JULY,2023)));

        // Kurumsal müşteri hesabı oluşturma
        Enterprise enterprise = new Enterprise(new User("XYZ Company","xyz@example.com","password"));
        enterprise.getUser().setAddresses(new BusinessAddress("456 Business Ave.", "San Francisco", "CA", "98765","England"));
        enterprise.addInsurance(new ResidenceInsurance("Home Insurance", 200.0,new Date(15, Calendar.AUGUST,2023),new Date(23,Calendar.JULY,2025)));

        accountManager.registerAccount(individualAccount);
        accountManager.registerAccount(enterprise);

        try {
            Account loggedInAccount = accountManager.login("john@example.com","123456");
            System.out.println("Giriş başarılı. Kullanıcı: " + loggedInAccount.getUser().getFirstName());
        } catch (InvalidAuthenticationException e) {
            System.out.println("Giriş başarısız. Hata: " + e.getMessage());
        }
    }
}
