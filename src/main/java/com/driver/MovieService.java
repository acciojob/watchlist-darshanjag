package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }
    public void addMovieDirectorPair(String movie, String director){
        movieRepository.saveMovieDirectorPair(movie, director);
    }
    public Movie getMovieByName(String name){
        Movie movie= movieRepository.findMovie(name);
        return movie;
    }
    public Director getDirectorByName(String name){
        Director director = movieRepository.findDirector(name);
        return director;
    }
    public List<String> getMoviesByDirectorName(String director){
        List<String> movies = movieRepository.findMoviesByDirectorName(director);
        return movies;
    }
    public List<String> findAllMovies(){
        List<String> movies = movieRepository.getMovies();
        return movies;
    }
    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }




}
