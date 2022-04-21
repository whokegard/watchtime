import React, {useContext, useEffect, useRef, useState} from "react";
import { Row, Col} from "react-bootstrap";
import {getAMembersWatchedMovies, getAMembersNonWatchedMovies} from "../../client";
import { UserContext } from "../general/UserContext";
import "../../css/MovieList.css";
import MovieCard from "./MovieCard";
import EmptyCard from "./EmptyCard";

const MovieList = () => {
    const [watchedMovies, setWatchedMovies] = useState([]);
    const [nonWatchedMovies, setNonWatchedMovies] = useState([]);
    const { user } = useContext(UserContext);
    const [loading, setLoading] = useState(false);
    const [data, setData] = useState(false);

    const childToParent = () => {
        setData(true);
        setWatchedMovies([]);
        setNonWatchedMovies([]);
        console.log("do");
    };

    const setMembersMovies = () => {
        setLoading(true);
        getAMembersWatchedMovies(user.member_id)
            .then(resp => resp)
            .then(res => res.json())
            .then(data => {
                setWatchedMovies(data);
                console.log(data);
                console.log("hello");
            });

        getAMembersNonWatchedMovies(user.member_id)
            .then(resp => resp)
            .then(res => res.json())
            .then(data => {
                setNonWatchedMovies(data);
                console.log(data);
                console.log("bye");
            });
        setLoading(false);
    }

    useEffect(() => {
        setMembersMovies();
        setData(false);
    }, [data])

    return (
        <div style={{margin: "0"}}>
            <div className="movie_list">
                <h5>Not Watched Movies</h5>
                <Row xs={1} md={6} className="g-4">
                    {nonWatchedMovies.length !== 0 ?
                        nonWatchedMovies.map((movie, index) => (
                            <Col
                                key={index}
                                style={{padding: "0"}}
                            >
                                {Array.from({length: 1}).map((data, index) => (
                                    <MovieCard
                                        key={index}
                                        watched={false}
                                        imdbId={movie.imdb_id}
                                        movieId={movie.movie_id}
                                        childToParent={childToParent}
                                    />
                                ))}
                            </Col>
                        ))
                        :
                        <Col>
                            <EmptyCard />
                        </Col>
                    }
                </Row>
                <h5 style={{paddingTop: "2rem"}}>Watched Movies</h5>
                <Row xs={1} md={6} className="g-4">
                    {watchedMovies.length !== 0 ?
                        watchedMovies.map((movie, index) => (
                            <Col
                                key={index}
                                style={{padding: "0"}}
                            >
                                {Array.from({length: 1}).map((data, index) => (
                                    <MovieCard
                                        key={index}
                                        imdbId={movie.imdb_id}
                                        watched={true}
                                        movieId={movie.movie_id}
                                        childToParent={childToParent}
                                    />
                                ))}
                            </Col>
                        ))
                        :
                        <Col>
                            <EmptyCard />
                        </Col>
                    }
                </Row>
            </div>
        </div>


    );
}

export default MovieList;