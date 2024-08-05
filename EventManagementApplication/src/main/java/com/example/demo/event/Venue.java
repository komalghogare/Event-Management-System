package com.example.demo.event;

@Entity
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int capacity;

    @OneToMany(mappedBy = "venue")
    private List<Event> events;

    // Getters and Setters
}
