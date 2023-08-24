import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String ch3ShipToCode;

    private String ch3ShipToName;

    private String chainName;

    public Customer() {
    }

    public String getCh3ShipToCode() {
        return ch3ShipToCode;
    }

    public void setCh3ShipToCode(String ch3ShipToCode) {
        this.ch3ShipToCode = ch3ShipToCode;
    }

    public String getCh3ShipToName() {
        return ch3ShipToName;
    }

    public void setCh3ShipToName(String ch3ShipToName) {
        this.ch3ShipToName = ch3ShipToName;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }
}


