package message.response;

import model.City;
import model.Event;

import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class EventReponse {

    private String voyage;
    private String type;
    private String name;
    private boolean active;
    private boolean delete;
    private City city;
    private Timestamp beginEvent;
    private Timestamp endEvent;
    private int nbCar;
    private String nameUser;

    public EventReponse(String voyage, String type, String name, boolean active, boolean delete, City codePostal, Timestamp timestamp, Timestamp timestampEnd, int nbCar, String nameUser) {
        this.voyage = voyage;
        this.type = type;
        this.name = name;
        this.active=active;
        this.delete=delete;
        this.city=codePostal;
        this.beginEvent=timestamp;
        this.endEvent=timestampEnd;
        this.nbCar=nbCar;
        this.nameUser=nameUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getNbCar() {
        return nbCar;
    }

    public void setNbCar(int nbCar) {
        this.nbCar = nbCar;
    }

    public Timestamp getEndEvent() {
        return endEvent;
    }

    public void setEndEvent(Timestamp endEvent) {
        this.endEvent = endEvent;
    }

    public Timestamp getBeginEvent() {
        return beginEvent;
    }

    public void setBeginEvent(Timestamp beginEvent) {
        this.beginEvent = beginEvent;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getVoyage() {
        return voyage;
    }

    public void setVoyage(String voyage) {
        this.voyage = voyage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
