package com.driver;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;
   public MovieRepository(){
       movieMap = new HashMap<String,Movie>();
       directorMap = new HashMap<String,Director>();
       directorMovieMapping= new HashMap<String,List<String>>();
   }
    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }
    public void saveDirector(Director director){
       directorMap.put(director.getName(),director);
    }
    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie)&&directorMap.containsKey(director)){

            List<String> currentMovies = new ArrayList<String>();
            if(directorMovieMapping.containsKey(director)) currentMovies = directorMovieMapping.get(director);
            currentMovies.add(movie);
            directorMovieMapping.put(director, currentMovies);
        }

    }
    public Movie findMovie(String name){
       return movieMap.get(name);

    }

    public Director findDirector(String director){
        return directorMap.get(director);
    }
    public List<String> findMoviesByDirectorName(String director){
       return directorMovieMapping.get(director);
    }
    public List<String>getMovies(){
        return new ArrayList<>(movieMap.keySet());
    }
    public void deleteDirector(String director){
        List<String> movies = new ArrayList<String>();
        if(directorMovieMapping.containsKey(director)){
            movies = directorMovieMapping.get(director);
            for ( String movie: movies){
                movieMap.remove(movie);
            }
        }
        directorMovieMapping.remove(director);
    }
    public void deleteAllDirectors(){
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String director: directorMovieMapping.keySet()){
            for(String movie: directorMovieMapping.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }
}
