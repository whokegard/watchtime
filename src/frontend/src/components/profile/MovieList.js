import React, {useContext, useEffect, useState} from "react";
import { Row, Col} from "react-bootstrap";
import {getAllOfAMembersMovies, getMembersWatchedMovies, getMembersNonWatchedMovies} from "../../client";
import { UserContext } from "../general/UserContext";
import MovieCard from "./MovieCard";
import "../../css/MovieList.css";

const MovieList = () => {
  const [watchedMovies, setWatchedMovies] = useState([]);
  const [nonWatchedMovies, setNonWatchedMovies] = useState([]);
  const { user } = useContext(UserContext);

  const fetchAMembersWatchedMovies = () => getMembersWatchedMovies(user.watchlist_id)
      .then(resp => resp)
      .then(res => res.json())
      .then(data => setWatchedMovies(data));

  useEffect(() => {
    fetchAMembersWatchedMovies();
  }, []);

  const fetchAMembersNonWatchedMovies = () => getMembersNonWatchedMovies(user.watchlist_id)
      .then(resp => resp)
      .then(res => res.json())
      .then(data => setNonWatchedMovies(data));

  useEffect(() => {
    fetchAMembersNonWatchedMovies();
  }, []);


  return (
      <div className="view">
      <div className="movie_list">
        <h5>Watched Movies</h5>
        <Row xs={1} md={6} className="g-4">
          {watchedMovies.map((movie, index) => (
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
        <h5>Not Watched Movies</h5>
          <Row xs={1} md={6} className="g-4">
              {nonWatchedMovies.map((movie, index) => (
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
      </div>


  );
}

export default MovieList;