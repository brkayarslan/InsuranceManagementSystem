package InsuranceManagementSystem;

public class BusinessAddress implements Address{
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public BusinessAddress(String street, String city, String state, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String getPostalCode() {
        return this.postalCode;
    }

    @Override
    public String getCountry() {
        return this.country;
    }
}
