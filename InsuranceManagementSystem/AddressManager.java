package InsuranceManagementSystem;

public class AddressManager {
    public static void addAddress(User user, Address address){
        user.setAddresses(address);
    }
    public static void removeAddress(User user, Address address){
        user.removeAddress(address);
    }
}
