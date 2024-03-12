package com.example.Movie;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(name = "movie_seq", sequenceName = "movie_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    @JsonProperty("Title")
    private String title;

    @Column(name = "year")
    @JsonProperty("Year")
    private String year;

    @JsonProperty("Rated")
    @Column(name = "rated")
    private String rated;

    @Column(name = "released")
    @JsonProperty("Released")
    private String released;

    @Column(name = "runtime")
    @JsonProperty("Runtime")
    private String runtime;

    @Column(name = "genre")
    @JsonProperty("Genre")
    private String genre;

    @Column(name = "director")
    @JsonProperty("Director")
    private String director;

    @Column(name = "writer")
    @JsonProperty("Writer")
    private String writer;

    @Column(name = "actors")
    @JsonProperty("Actors")
    private String actors;

    @Column(name = "plot")
    @JsonProperty("Plot")
    private String plot;

    @Column(name = "language")
    @JsonProperty("Language")
    private String language;

    @Column(name = "country")
    @JsonProperty("Country")
    private String country;

    @Column(name = "awards")
    @JsonProperty("Awards")
    private String awards;

    @Column(name = "poster")
    @JsonProperty("Poster")
    private String poster;

    @Column(name = "rottenTomatoesRating")
    @JsonProperty("RottenTomatoesRating")
    private String rottenTomatoesRating;

}