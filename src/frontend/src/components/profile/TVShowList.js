import React, {useContext, useEffect, useState} from "react";
import { Row, Col} from "react-bootstrap";
import MovieCard from "./MovieCard";
import "../../css/MovieList.css";
import {UserContext} from "../general/UserContext";
import {getAMembersWatchedTVShows, getAMembersNonWatchedTVShows} from "../../client";

const TVShowList = () => {
    const [watchedTVShows, setWatchedTVShows] = useState([]);
    const [nonWatchedTVShows, setNonWatchedTVShows] = useState([]);
    const { user } = useContext(UserContext);

    const fetchAMembersWatchedTVShows = () => getAMembersWatchedTVShows(user.member_id)
        .then(resp => resp)
        .then(res => res.json())
        .then(data => {
            setWatchedTVShows(data);
            console.log(data);
        });

    useEffect(() => {
        fetchAMembersWatchedTVShows();
    }, []);

    const fetchAMembersNonWatchedTVShows = () => getAMembersNonWatchedTVShows(user.member_id)
        .then(resp => resp)
        .then(res => res.json())
        .then(data => {
            setNonWatchedTVShows(data);
            console.log(data);
        });

    useEffect(() => {
        fetchAMembersNonWatchedTVShows();
    }, []);


    return (
        <div className="view">
            <div className="movie_list">
                <h5>Not Watched TV-Shows</h5>
                <Row xs={1} md={6} className="g-4">
                    {nonWatchedTVShows.map((tvshow, index) => (
                        <Col
                            key={index}
                            style={{padding: "0"}}
                        >
                            {Array.from({ length: 1 }).map((_, idx) => (
                                <MovieCard key={tvshow.tvshow_id} imdbId={tvshow.imdb_id}/>
                            ))}
                        </Col>
                    ))}
                </Row>
                <h5 style={{paddingTop: "2rem"}}>Watched TV-Shows</h5>
                <Row xs={1} md={6} className="g-4">
                    {watchedTVShows.map((tvshow, index) => (
                        <Col
                            key={index}
                            style={{padding: "0"}}
                        >
                            {Array.from({ length: 1 }).map((_, idx) => (
                                <MovieCard key={tvshow.tvshow_id} imdbId={tvshow.imdb_id}/>
                            ))}
                        </Col>
                    ))}
                </Row>
            </div>
        </div>


    );
}

export default TVShowList;