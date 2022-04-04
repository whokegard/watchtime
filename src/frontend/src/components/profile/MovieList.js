import React, {useEffect, useState} from "react";
import { Row, Col} from "react-bootstrap";
import {getAllOfAMembersMovies} from "../../client";
import MovieCard from "./MovieCard";
import "../../css/MovieList.css";

const MovieList = () => {
  const [movies, setMovies] = useState([]);

  const fetchAMembersMovies = () => getAllOfAMembersMovies()
      .then(resp => resp)
      .then(res => res.json())
      .then(data => setMovies(data));

  useEffect(() => {
    fetchAMembersMovies();
  }, [movies]);


  return (
      <div className="movie_list">
        <h5>Movies</h5>
        <Row xs={1} md={6} className="g-4">
          {movies.map((movie, index) => (
              <Col
                 key={index}
                 style={{padding: "0"}}
              >
               {Array.from({ length: 1 }).map((_, idx) => (
                   <MovieCard key={movie.movie_id} imdbId={movie.imdb_id}/>
               ))}
             </Col>
          ))}
        </Row>
      </div>


  );
}

export default MovieList;