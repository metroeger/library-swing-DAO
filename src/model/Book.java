
package model;

import java.util.Date;
import model.DBModel;


public class Book {
    private int id;
    private String title;
    private int clientId;  
    private int authorId;
    private boolean taken;
//    private Date from;
//    private Date until;
    
    public Book(){
        
    }
    public Book (int id, int authorId, String title, int clientId){
        this.id = id;
        this.authorId = authorId;
        this.title=title;
        this.clientId = clientId;
        this.taken = ((clientId==1) ? false : true);
    }


    
   public Book (int authorId, String Title, int clientId){
        this.title=title;
        this.clientId = clientId;
        this.authorId = authorId;
        this.taken = ((clientId==1) ? false : true);
   }
   
//   public String getAuthorName(int id){
//       String authorName = getAuthorName(id);
//       return authorName;
//   }

   
    @Override
    public String toString() {
        if (taken){
        return "[" + id + "] Title: " + title + " " + authorId + " IS TAKEN by: " + clientId ;
        }else{
            return "[" + id + "] Title: " + title + " " + ", authorId: " + authorId + ", AVAILABLE: " + !taken;
        }
    }

        public boolean isTaken() {
        return taken;
    }

    public void setTaken(int clientId) {
        this.taken = ((clientId==1) ? false : true);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

//    public Date getFrom() {
//        return from;
//    }
//
//    public void setFrom(Date from) {
//        this.from = from;
//    }

 

//    public Date getUntil() {
//        return until;
//    }
//
//    public void setUntil(Date until) {
//        this.until = until;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
      
      
}
