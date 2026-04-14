package classes;

import jakarta.persistence.Entity;

@Entity
public class Agency {
    private String name;

    private String country;

    private String history;

    private String info;

    public Agency(String name, String country, String history, String info) {
        this.name = name;
        this.country = country;
        this.history = history;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getHistory() {
        return history;
    }

    public String getInfo() {
        return info;
    }
}
