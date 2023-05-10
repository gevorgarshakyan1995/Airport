package com.connectto.model;

import com.connectto.enums.StatusTicket;

import javax.persistence.*;
import java.util.List;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Airplane airplane;

    @OneToMany(mappedBy = "flight" ,cascade = CascadeType.ALL)
    private List<Book> book;

    @Enumerated(EnumType.STRING)
    @Column(name = "Baggage_status")
    private StatusTicket statusTicket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public StatusTicket getStatusTicket() {
        return statusTicket;
    }

    public void setStatusTicket(StatusTicket statusTicket) {
        this.statusTicket = statusTicket;
    }
}
