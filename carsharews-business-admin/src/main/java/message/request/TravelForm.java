package message.request;

import model.City;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class TravelForm {

    private String dispo;
    private String city;
    private String name;
    private String typeCar;
    private String token;
    private boolean active;
    private String codePostal;
    private City cityEvent;
    private Timestamp beginEvent;
    private Timestamp endEvent;
    private int occuped;

    public TravelForm() {
    }

    public TravelForm(String dispo, String voyage, String nameEvent, String typeCar,
                      String token, boolean active, String codePostal, City cityEvent, Timestamp timestamp,Timestamp timestampEnd, int occuped) {
        this.dispo = dispo;
        this.city = voyage;
        this.name = nameEvent;
        this.typeCar = typeCar;
        this.token = token;
        this.active = active;
        this.codePostal = codePostal;
        this.cityEvent=cityEvent;
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

    public void setCityEvent(City cityEvent) {
        this.cityEvent = cityEvent;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
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
