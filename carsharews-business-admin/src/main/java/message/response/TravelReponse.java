package message.response;

import model.City;

import java.sql.Timestamp;

public class TravelReponse {

    private String dispo;
    private String city;
    private String name;
    private String typeCar;
    private String token;
    private boolean active;
    private City codePostal;
    private City cityEvent;
    private Timestamp beginEvent;
    private Timestamp endEvent;
    private int occuped;

    public TravelReponse(String dispo, String voyage, String nameEvent, String typeCar, String token, boolean active, City codePostal, City cityEvent, Timestamp timestamp,Timestamp timestampEnd, int occuped) {
        this.dispo = dispo;
        this.city = voyage;
        this.name = nameEvent;
        this.typeCar = typeCar;
        this.token = token;
        this.active = active;
        this.cityEvent =cityEvent;
        this.codePostal =codePostal;
        this.beginEvent = timestamp;
        this.endEvent = timestampEnd;
        this.occuped=occuped;
    }

    public int getOccuped() {
        return occuped;
    }

    public void setOccuped(int occuped) {
        this.occuped = occuped;
    }

    public Timestamp getBeginEvent() {
        return beginEvent;
    }

    public void setBeginEvent(Timestamp beginEvent) {
        this.beginEvent = beginEvent;
    }

    public Timestamp getEndEvent() {
        return endEvent;
    }

    public void setEndEvent(Timestamp endEvent) {
        this.endEvent = endEvent;
    }

    public City getCityEvent() {
        return cityEvent;
    }

    public void setCityEvent(City city1) {
        this.cityEvent = city1;
    }

    public City getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(City codePostal) {
        this.codePostal = codePostal;
    }

    public String getDispo() {
        return dispo;
    }

    public void setDispo(String dispo) {
        this.dispo = dispo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameEvent) {
        name = nameEvent;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
