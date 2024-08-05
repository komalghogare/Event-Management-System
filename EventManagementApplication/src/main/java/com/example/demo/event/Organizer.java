package com.example.demo.event;


@Entity
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactInfo;

    @OneToMany(mappedBy = "organizer")
    private List<Event> events;

    // Getters and Setters
}

