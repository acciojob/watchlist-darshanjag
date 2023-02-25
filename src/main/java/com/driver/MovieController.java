package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired MovieService movieServices;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieServices.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieServices.addDirector(director);
        return new ResponseEntity<>("New director added successfully",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestBody String movie, @RequestBody String director){
        movieServices.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie-director pair added successylly",HttpStatus.CREATED);

    }
    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie = movieServices.getMovieByName(name);
        return new ResponseEntity(movie,HttpStatus.CREATED);
    }

    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        Director director = movieServices.getDirectorByName(name);
        return new ResponseEntity(director,HttpStatus.CREATED);

    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity  getMoviesByDirectorName(@PathVariable String director){
        List <String> movies = movieServices.getMoviesByDirectorName(director);
        return new ResponseEntity(movies,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity  findAllMovies(){
        List<String> movies = movieServices.findAllMovies();
        return new ResponseEntity(movies,HttpStatus.CREATED);
    }

    @DeleteMapping("delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String director){
        movieServices.deleteDirector(director);
        return new ResponseEntity<>(director + " removed successfully", HttpStatus.CREATED);

    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieServices.deleteAllDirectors();
        return new ResponseEntity("All directors deleted successfully",HttpStatus.CREATED);
    }



}
