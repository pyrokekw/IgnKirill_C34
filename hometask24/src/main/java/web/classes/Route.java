package web.classes;

public class Route {

    private int id;
    private String name;
    private String description;
    private double length;
    private int votes;

    public Route(int id, String name, String description, double length, int votes) {
        this.name = name;
        this.description = description;
        this.length = length;
        this.votes = 0;
    }

    public Route() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
