package com.example.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
  @GetMapping("/")
    public String showForm() {
        return "form";
    }



@PostMapping("/search")
   public String searchMovie(@RequestParam("movieName")  String movieName, Model model) {
        String uri = "http://www.omdbapi.com/?apikey=b79fdda2&t=" + movieName;
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try {
            String response = restTemplate.getForObject(uri,String.class);
            //ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            Movie movie = mapper.readValue(response, Movie.class);
            System.out.println(movie.toString());
            model.addAttribute("movie", movie);
            return "result";
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving movie data");
            return "form";
        }

    }
    /*
  @PostMapping("/search")
 public String showSavedMovies(@RequestParam("movieName") String movieName, Model model) throws JsonProcessingException {
     Movie movie = movieService.getMovieFromAPI(movieName);

     model.addAttribute("movie", movie);
     return "result";
 }*/



}