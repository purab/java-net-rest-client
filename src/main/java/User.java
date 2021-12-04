import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "user")
public class User {

    private Long id;
    private String name;
    private String job;


    public User() {
        super();
    }

    public User(Long id, String name, String job) {
        super();
        this.id = id;
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", job=" + job + "]";
    }
    //All Getters, Setters here

}
