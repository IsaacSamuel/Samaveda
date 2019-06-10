package samaveda;


public class Song {
    private final String name;
    private final String id;


    public Song(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return id;
    }

}
