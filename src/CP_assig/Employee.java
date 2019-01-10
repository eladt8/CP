package CP_assig;

public class Employee {

    private Integer m_id;
    private String m_firstName;
    private String m_lastName;
    private String m_email;


    public Employee(Integer m_id, String m_firstName, String m_lastName, String m_email) {
        this.m_id = m_id;
        this.m_firstName = m_firstName;
        this.m_lastName = m_lastName;

        this.m_email = m_email;
    }
    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_firstName() {
        return m_firstName;
    }

    public void setM_firstName(String m_firstName) {
        this.m_firstName = m_firstName;
    }

    public String getM_lastName() {
        return m_lastName;
    }

    public void setM_lastName(String m_lastName) {
        this.m_lastName = m_lastName;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }


}
