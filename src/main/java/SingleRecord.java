import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SingleRecord {

    private int item;
    private String ccard;
    private String name;
    private String lname;
    private int code;

    public SingleRecord() {
        item = 0;
        ccard = "";
        name = "";
        lname = "";
        code = 0;
    }

    public SingleRecord(int item, String ccard, String name, String lname, int code) {
        this.item = item;
        this.ccard = ccard;
        this.name = name;
        this.lname = lname;
        this.code = code;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getCcard() {
        return ccard;
    }

    public void setCcard(String ccard) {
        this.ccard = ccard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SingleRecord{" +
                "item=" + item +
                ", ccard=" + ccard +
                ", name='" + name + '\'' +
                ", lname='" + lname + '\'' +
                ", code=" + code +
                '}';
    }
}
