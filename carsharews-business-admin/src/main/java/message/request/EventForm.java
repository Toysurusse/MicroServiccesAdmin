package message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class EventForm {
    @NotBlank
    @Size(min=3, max = 50)
    private String nameEvent;

    @NotBlank
    @Size(min=3, max = 100)
    private String type;

    @NotBlank
    @Size(min=3, max = 50)
    private String voyage;

    @NotBlank
    @Size(min=1, max = 5)
    private String codePostal;

    private boolean delete;

    private boolean active;

    private Timestamp beginEvent;

    private Timestamp endEvent;

    @NotBlank
    private String token;

    private int nbCar;

    public EventForm() {

    }

    public EventForm(@NotBlank @Size(min = 3, max = 50) String nameEvent, @NotBlank @Size(min = 3, max = 100) String type, @NotBlank @Size(min = 3, max = 50) String voyage,
                     boolean delete, boolean active, @NotBlank String token, String codePostal, Timestamp timestamp, Timestamp timestampEnd, int nbCar) {
        this.nameEvent = nameEvent;
        this.type = type;
        this.voyage = voyage;
        this.delete = delete;
        this.active = active;
        this.token = token;
        this.codePostal= codePostal;
        this.beginEvent=timestamp;
        this.endEvent=timestampEnd;
        this.nbCar=nbCar;
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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVoyage() {
        return voyage;
    }

    public void setVoyage(String voyage) {
        this.voyage = voyage;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
