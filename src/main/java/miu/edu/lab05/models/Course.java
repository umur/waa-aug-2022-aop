package miu.edu.lab05.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String code;
}
