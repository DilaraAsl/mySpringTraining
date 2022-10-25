package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor
@Data
@Entity
public class Movie extends BaseEntity {

    private Integer duration;
    private String name;
    private BigDecimal price;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private MovieState state;


    @Column(columnDefinition = "text") // text provides more space
    private String summary;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @ManyToMany
    @JoinTable(name="movie_genre_rel", joinColumns = @JoinColumn( name="movie_id"),inverseJoinColumns = @JoinColumn(name="genre_id"))
    private List<Genre> genreList;
}
