import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.beans.Transient;

public class MappedObject {
    private int a;
    private String b;
    private boolean c;
    private double d;
    public String title;

    @XmlTransient
    public String getTitle() {
        return title;
    }

    @XmlElement
    public int getA() {
        return a;
    }

    @XmlElement
    public String getB() {
        return b;
    }

    @XmlElement
    public boolean isC() {
        return c;
    }

    @XmlElement
    public double getD() {
        return d;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public void setD(double d) {
        this.d = d;
    }
}
