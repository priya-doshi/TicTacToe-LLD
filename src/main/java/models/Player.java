package models;


import java.util.UUID;

public class Player {
    private String id;
    private String name;
    private Piece piece;

    public Player(String name, Piece piece) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.piece = piece;
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

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
