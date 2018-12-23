package model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBModel implements IModel {

    private Connection conn;
    private PreparedStatement getAllClientPstmt;
    private PreparedStatement getAllBookPstmt;
    private PreparedStatement addClientPstmt;
    private PreparedStatement addBookPstmt;
    private PreparedStatement updateClientPstmt;
    private PreparedStatement updateBookPstmt;
    private PreparedStatement deleteClientPstmt;
    private PreparedStatement deleteBookPstmt;
    private PreparedStatement getAlLBookOfClientPstmt;
    private PreparedStatement getAlLAuthorPstmt;
    private PreparedStatement addAuthorPstmt;
    private PreparedStatement updateAuthorPstmt;
    private PreparedStatement deleteAuthorPstmt;
    private PreparedStatement getAlLBookOfAuthorPstmt;
    private PreparedStatement getAllAvailableBookPstmt;
    private PreparedStatement getAllAvailableBookOfAuthorPstmt;
    private PreparedStatement getAuthorNameByIdPstmt;
    private PreparedStatement findAuthorByNamePstmt;
    private PreparedStatement findClientByNamePstmt;

    public static String authorName;

    public DBModel(Connection conn) throws SQLException {
        this.conn = conn;
        getAllClientPstmt = conn.prepareStatement("SELECT * FROM client");
        getAllBookPstmt = conn.prepareStatement("SELECT * FROM book");
        addClientPstmt = conn.prepareStatement("INSERT INTO client (name, email) VALUES (?, ?)");
        addBookPstmt = conn.prepareStatement("INSERT INTO book(authorId, title, clientId, taken) VALUES (?,?,?,?)");
        updateClientPstmt = conn.prepareStatement("UPDATE client SET name=?, email=? WHERE id=?");
        updateBookPstmt = conn.prepareStatement("UPDATE book SET authorId=?, title=?, clientId=?, taken=? WHERE id=?");
        deleteClientPstmt = conn.prepareStatement("DELETE FROM client WHERE id=?");
        deleteBookPstmt = conn.prepareStatement("DELETE FROM book WHERE id=?");
        getAlLBookOfClientPstmt = conn.prepareStatement("SELECT * FROM book JOIN client ON book.clientId=client.id WHERE clientId=?");
        getAlLAuthorPstmt = conn.prepareStatement("SELECT * FROM author");
        addAuthorPstmt = conn.prepareStatement("INSERT INTO author (name) VALUES (?)");
        updateAuthorPstmt = conn.prepareStatement("UPDATE author SET name=? WHERE id=?");
        deleteAuthorPstmt = conn.prepareStatement("DELETE FROM author WHERE id=?");
        getAlLBookOfAuthorPstmt = conn.prepareStatement("SELECT * FROM book JOIN author ON book.authorId=author.id WHERE authorId=?");
        getAllAvailableBookPstmt = conn.prepareStatement("SELECT * FROM book WHERE clientId=?");
        getAllAvailableBookOfAuthorPstmt = conn.prepareStatement("SELECT * FROM book JOIN author ON book.authorId=author.id WHERE (authorId=? && clientId=?)");
        getAuthorNameByIdPstmt = conn.prepareStatement("SELECT name FROM author WHERE id=?");
        findAuthorByNamePstmt = conn.prepareStatement("SELECT * FROM author WHERE name LIKE ?");
        findClientByNamePstmt = conn.prepareStatement("SELECT * FROM client WHERE name LIKE ?");
    }

    @Override
    public List<Client> getAllClient() throws SQLException {
        List<Client> clients = new ArrayList<>();
        ResultSet rs = getAllClientPstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");

            clients.add(new Client(id, name, email));
        }
        rs.close();
        return clients;
    }

    @Override
    public int addClient(Client c) throws SQLException {
        addClientPstmt.setString(1, c.getName());
        addClientPstmt.setString(2, c.getEmail());
        // int rows = addClientPstmt.executeUpdate();
        System.out.println("Record's inserted into Client table!");
        return addClientPstmt.executeUpdate();
    }

    @Override
    public int updateClient(Client sz) throws SQLException {
        updateClientPstmt.setString(1, sz.getName());
        updateClientPstmt.setString(2, sz.getEmail());
        updateClientPstmt.setInt(3, sz.getId());
        System.out.println("Client's UPDATED!");
        return updateClientPstmt.executeUpdate();
    }

    @Override
    public int removeClient(Client sz) throws SQLException {
        deleteClientPstmt.setInt(1, sz.getId());
        int rows = deleteClientPstmt.executeUpdate();
        System.out.println("Client'ss DELETED!");
        return rows;
    }

    @Override
    public List<Book> getAllBook() throws SQLException {
        List<Book> books = new ArrayList<>();
        ResultSet rs = getAllBookPstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            int authorId = rs.getInt("authorId");
            String title = rs.getString("title");
            int clientId = rs.getInt("clientId");
            boolean taken = rs.getBoolean("taken");
//            Date from = rs.getDate("from");
//            Date until = rs.getDate("until");
            books.add(new Book(id, authorId, title, clientId));
        }
        rs.close();
        return books;
    }

    @Override
    public List<Book> getAllBook(Client c) throws SQLException {
        List<Book> booksOfClient = new ArrayList<>();
        getAlLBookOfClientPstmt.setInt(1, c.getId());
        ResultSet rs = getAlLBookOfClientPstmt.executeQuery();
        while (rs.next()) {
//            int id = rs.getInt("id");
//            int clientId = rs.getInt("clientId");
//            int osszeg = rs.getInt("osszeg");
//            int darabszam = rs.getInt("darabszam");
            booksOfClient.add(new Book(
                    rs.getInt("id"),
                    rs.getInt("authorId"),
                    rs.getString("title"),
                    rs.getInt("clientId")));
                            
        }
        rs.close();
        return booksOfClient;
    }

    @Override
    public List<Book> getAllBook(Author a) throws SQLException {
        List<Book> booksByAuthor = new ArrayList<>();
        getAlLBookOfAuthorPstmt.setInt(1, a.getId());
        ResultSet rs = getAlLBookOfAuthorPstmt.executeQuery();
        while (rs.next()) {
            booksByAuthor.add(new Book(
                    rs.getInt("id"),
                    rs.getInt("authorId"),
                    rs.getString("title"),
                    rs.getInt("clientId")));
                    //rs.getBoolean("taken")));
        }
        rs.close();
        return booksByAuthor;
    }

    @Override
    public int addBook(Book b) throws SQLException {
        addBookPstmt.setInt(1, b.getAuthorId());
        addBookPstmt.setString(2, b.getTitle());
        addBookPstmt.setInt(3, b.getClientId());
        addBookPstmt.setBoolean(4, b.isTaken());
        System.out.println("Book's been added!");
        int rows = addBookPstmt.executeUpdate();
        return rows;
    }

    @Override
    public int updateBook(Book b) throws SQLException {
        updateBookPstmt.setInt(1, b.getAuthorId());
        updateBookPstmt.setString(2, b.getTitle());
        updateBookPstmt.setInt(3, b.getClientId());
        updateBookPstmt.setBoolean(4, b.isTaken());
        updateBookPstmt.setInt(5, b.getId());
//        System.out.println("Book is UPDATED!");
//        System.out.println("Authorid: " + b.getAuthorId());
//        System.out.println("Title: " + b.getTitle());
//        System.out.println("Id: " + b.getId());
        return updateBookPstmt.executeUpdate();
    }

    @Override
    public int removeBook(Book r) throws SQLException {
        deleteBookPstmt.setInt(1, r.getId());
        int rows = deleteBookPstmt.executeUpdate();
        return rows;
    }

    @Override
    public List<Author> getAllAuthor() throws SQLException {
        List<Author> authors = new ArrayList<>();
        ResultSet rs = getAlLAuthorPstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            authors.add(new Author(id, name));
        }
        rs.close();
        return authors;
    }

    @Override
    public int addAuthor(Author a) throws SQLException {
        addAuthorPstmt.setString(1, a.getName());
        return addAuthorPstmt.executeUpdate();
    }

    @Override
    public int updateAuthor(Author a) throws SQLException {
        updateAuthorPstmt.setString(1, a.getName());
        updateAuthorPstmt.setInt(2, a.getId());
        System.out.println("Author's UPDATED!");
        return updateAuthorPstmt.executeUpdate();
    }

    @Override
    public int removeAuthor(Author a) throws SQLException {
        deleteAuthorPstmt.setInt(1, a.getId());
        return deleteAuthorPstmt.executeUpdate();
    }

    @Override
    public void close() throws SQLException {
        conn.close();
    }

    @Override
    public void exportToFile(File f) throws Exception {
        // CSV filet csinal belole
        PrintWriter pw = new PrintWriter(new FileWriter(f));
        pw.println("id;name;email");
        List<Client> clients = getAllClient();
        for (Client c : clients) {
            pw.println(c.getId() + ";" + c.getName() + ";" + c.getEmail());
        }
        pw.println("id;clientId;title;clientId;taken");
        List<Book> books = getAllBook();
        for (Book b : books) {
            pw.println(b.getId() + ";" + b.getAuthorId() + ";" + b.getTitle() + ";" + b.getClientId() + ";" + b.isTaken());
        }
        pw.println("id;name;email");
        List<Author> authors = getAllAuthor();
        for (Author a : authors) {
            pw.println(a.getId() + ";" + a.getName());
        }
        pw.close();
    }

    @Override
    public List<Book> getAllAvailableBook() throws SQLException {
        List<Book> availableBooks = new ArrayList<>();
        getAllAvailableBookPstmt.setInt(1, 1);
        ResultSet rs = getAllAvailableBookPstmt.executeQuery();
        while (rs.next()) {
            availableBooks.add(new Book(
                    rs.getInt("id"),
                    rs.getInt("authorId"),
                    rs.getString("title"),
                    rs.getInt("clientId")));
                    //rs.getBoolean("taken")));
        }
        rs.close();
        return availableBooks;
    }

    @Override
    public List<Book> getAllAvailableBookOfAuthor(Author a) throws SQLException {
        List<Book> availableBooksOfAuthor = new ArrayList<>();
        getAllAvailableBookOfAuthorPstmt.setInt(1, a.getId());
        getAllAvailableBookOfAuthorPstmt.setInt(2, 1);
        ResultSet rs = getAllAvailableBookOfAuthorPstmt.executeQuery();
        while (rs.next()) {
            availableBooksOfAuthor.add(new Book(
                    rs.getInt("id"),
                    rs.getInt("authorId"),
                    rs.getString("title"),
                    rs.getInt("clientId")));
                    //rs.getBoolean("taken")));
        }
        rs.close();
        return availableBooksOfAuthor;

    }

    @Override
    public String authorName(int id) throws SQLException {
        getAuthorNameByIdPstmt.setInt(1, id);
        ResultSet rs = getAuthorNameByIdPstmt.executeQuery();
        String name = "";
        while (rs.next()) {
            name = rs.getString("name");
        }
        rs.close();
        return name;
    }

    @Override
    public Author findAuthorByName(String name) throws SQLException {
        Author author = null;
        findAuthorByNamePstmt.setString(1, "%" + name + "%");
        ResultSet rs = findAuthorByNamePstmt.executeQuery();
        while (rs.next()) {
            author = new Author(rs.getInt("id"), rs.getString("name"));
        }
        rs.close();
        return author;
    }

    @Override
    public Client findClientByName(String name) throws SQLException {
        Client client = null;
        findClientByNamePstmt.setString(1, "%" + name + "%");
        ResultSet rs = findClientByNamePstmt.executeQuery();
        while (rs.next()) {
            client = new Client(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
        }
        rs.close();
        return client;
    }

}
