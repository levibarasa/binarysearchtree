
package project5;

public class Company {
    private String name;
    private String URL;
    private String city;
    private String state; 
    private String country; 

    public Company(String name, String URL, String city, String state, String country) {
        this.name = name;
        this.URL = URL;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Company{" + "name=" + name + ", URL=" + URL + ", city=" + city + ", state=" + state + ", country=" + country + '}';
    }

    public Company() {
    }
    
    
}
