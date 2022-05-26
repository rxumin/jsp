package beans;

public class Student {
    private String id;
    private String name;
    private String sex;
    private String major;
    private String hometown;

    public Student(String id, String name, String sex, String major, String hometown) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.hometown = hometown;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}
