import javax.persistence.*;

@Entity
@Table(name = "actuals")
public class Actual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String materialNo;

    private String ch3ShipToCode;

    private String chain;

    private Integer volume;

    private Double actualSalesValue;

    @Transient
    private String promoFlag;

    public Actual() {
    }

    public Actual(Long id, String date, String materialNo, String ch3ShipToCode, String chain, Integer volume, Double actualSalesValue, String promoFlag) {
        this.id = id;
        this.date = date;
        this.materialNo = materialNo;
        this.ch3ShipToCode = ch3ShipToCode;
        this.chain = chain;
        this.volume = volume;
        this.actualSalesValue = actualSalesValue;
        this.promoFlag = promoFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getCh3ShipToCode() {
        return ch3ShipToCode;
    }

    public void setCh3ShipToCode(String ch3ShipToCode) {
        this.ch3ShipToCode = ch3ShipToCode;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getActualSalesValue() {
        return actualSalesValue;
    }

    public void setActualSalesValue(Double actualSalesValue) {
        this.actualSalesValue = actualSalesValue;
    }

    public String getPromoFlag() {
        return promoFlag;
    }

    public void setPromoFlag(String promoFlag) {
        this.promoFlag = promoFlag;
    }
}

