package credit.model;

import org.springframework.data.annotation.Id;

public class Credit {

    @Id
    private int ID;
    private String creditName;

    public Credit(int ID, String creditName) {
        this.ID = ID;
        this.creditName = creditName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }
}
