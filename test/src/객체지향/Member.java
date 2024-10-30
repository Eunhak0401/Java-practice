package 객체지향;

public class Member {

    private String id;
    private String name;
    private int point;

    public Member() {


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
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }

    public Member(String id, String name, int point) {
        super();
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public void Draw() {
        System.out.println(id + " "+name+" "+point);
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", point=" + point + "]";
    }
}
