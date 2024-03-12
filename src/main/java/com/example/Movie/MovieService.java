package com.example.Movie;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URL;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieFromAPI(String name) throws JsonProcessingException {
        //Search movie json
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omdbapi.com/?apikey=b79fdda2&t=";

        //Convert it to object
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.disable (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //alternatively, you can use annotation @JsonIgnoreProperties(ignoreUnknown = true)
        //at Class level in Movie class.
        Movie movie = objectMapper.readValue(restTemplate.getForObject(url + name, String.class), Movie.class);

        Movie existingMovie = movieRepository.findByTitle(movie.getTitle());
        if (existingMovie == null) {
            movieRepository.save(movie);
        }

        return movie;

    }
}
