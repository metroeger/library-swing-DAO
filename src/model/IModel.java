
package model;

import java.io.File;
import java.sql.SQLException;
import java.util.List;


public interface IModel {
    
    List<Client> getAllClient() throws SQLException;
    int addClient(Client c) throws SQLException;
    int updateClient(Client c) throws SQLException;
    int removeClient(Client c) throws SQLException;
    
    List<Book>getAllBook() throws SQLException; 
    List<Book>getAllAvailableBook() throws SQLException;
    List<Book>getAllBook(Client c) throws SQLException; 
    List<Book>getAllBook(Author a) throws SQLException;
    List<Book>getAllAvailableBookOfAuthor(Author a) throws SQLException;
    
    Author findAuthorByName(String name) throws SQLException;
    Client findClientByName(String name) throws SQLException;

    
    int addBook(Book b) throws SQLException;
    int updateBook(Book b) throws SQLException;
    int removeBook(Book b) throws SQLException;   
    
    List<Author> getAllAuthor() throws SQLException;
    int addAuthor(Author a) throws SQLException;
    int updateAuthor(Author a) throws SQLException;
    int removeAuthor(Author a) throws SQLException;

    
    String authorName(int id)throws SQLException;
    
    void close() throws SQLException;
    void exportToFile(File f) throws Exception; // fajl kimentese (pl CSV fileba)
}
