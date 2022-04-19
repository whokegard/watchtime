import React, {useContext, useEffect, useRef, useState} from "react";
import { Row, Col} from "react-bootstrap";
import {getAMembersWatchedMovies, getAMembersNonWatchedMovies} from "../../client";
import { UserContext } from "../general/UserContext";
import "../../css/MovieList.css";
import MovieCard from "./MovieCard";

const MovieList = () => {
    const [watchedMovies, setWatchedMovies] = useState([]);
    const [nonWatchedMovies, setNonWatchedMovies] = useState([]);
    const { user } = useContext(UserContext);

    const childToParent = () => {

        setWatchedMovies([]);
        setNonWatchedMovies([]);
        fetchAMembersWatchedMovies();
        fetchAMembersNonWatchedMovies();
        console.log("do");
    };

    const fetchAMembersWatchedMovies = () => getAMembersWatchedMovies(user.member_id)
        .then(resp => resp)
        .then(res => res.json())
        .then(data => {
            setWatchedMovies(data);
            console.log(data);
            console.log("hello");
        });

    useEffect(() => {
        fetchAMembersWatchedMovies();
        fetchAMembersNonWatchedMovies();
        console.log("yello");
    }, []);

    const fetchAMembersNonWatchedMovies = () => getAMembersNonWatchedMovies(user.member_id)
        .then(resp => resp)
        .then(res => res.json())
        .then(data => {
            setNonWatchedMovies(data);
            console.log(data);
            console.log("bye");
        });


    return (
        <div style={{margin: "0"}}>
            <div className="movie_list">
                <h5>Not Watched Movies</h5>
                <Row xs={1} md={6} className="g-4">
                    {nonWatchedMovies.map((movie, index) => (
                        <Col
                            key={index}
                            style={{padding: "0"}}
                        >
                            {Array.from({ length: 1 }).map((data, index) => (
                                <MovieCard
                                    key={index}
                                    watched={false}
                                    imdbId={movie.imdb_id}
                                    movieId={movie.movie_id}
                                    childToParent={childToParent}
                                />
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
                            {Array.from({ length: 1 }).map((data, index) => (
                                <MovieCard
                                    key={index}
                                    imdbId={movie.imdb_id}
                                    watched={true}
                                    movieId={movie.movie_id}
                                    childToParent={childToParent}
                                />
                            ))}
                        </Col>
                    ))}
                </Row>
            </div>
        </div>


    );
}

export default MovieList;