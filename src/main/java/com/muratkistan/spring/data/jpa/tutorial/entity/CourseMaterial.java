package com.muratkistan.spring.data.jpa.tutorial.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseMateriralId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
//            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
