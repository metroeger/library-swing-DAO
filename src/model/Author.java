
package model;


public class Author {
    private int id;
    private String name;
    
    public Author(){
        
    }
    public Author(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Author(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[id: " + id + "] Name: " + name;
    }
    
}
