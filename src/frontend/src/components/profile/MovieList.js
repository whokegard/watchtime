import React, {useContext, useEffect, useState} from "react";
import { Row, Col} from "react-bootstrap";
import {getAMembersWatchedMovies, getAMembersNonWatchedMovies} from "../../client";
import { UserContext } from "../general/UserContext";
import "../../css/MovieList.css";
import MovieCard from "./MovieCard";

const MovieList = () => {
  const [watchedMovies, setWatchedMovies] = useState([]);
  const [nonWatchedMovies, setNonWatchedMovies] = useState([]);
  const { user } = useContext(UserContext);

  const fetchAMembersWatchedMovies = () => getAMembersWatchedMovies(user.member_id)
      .then(resp => resp)
      .then(res => res.json())
      .then(data => {
        setWatchedMovies(data);
        console.log(data);
      });

  useEffect(() => {
    fetchAMembersWatchedMovies();
  }, []);

  const fetchAMembersNonWatchedMovies = () => getAMembersNonWatchedMovies(user.member_id)
      .then(resp => resp)
      .then(res => res.json())
      .then(data => {
        setNonWatchedMovies(data);
        console.log(data);
      });

  useEffect(() => {
    fetchAMembersNonWatchedMovies();
  }, []);


  return (
      <div className="view">
      <div className="movie_list">
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
        <h5 style={{paddingTop: "2rem"}}>Watched Movies</h5>
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
      </div>
      </div>


  );
}

export default MovieList;