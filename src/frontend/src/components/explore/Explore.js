
import React, {useContext, useEffect, useState, useRef} from "react";
import { Input, Space } from 'antd';
import { AiOutlinePlusSquare } from 'react-icons/ai';
import {Col, Row} from "react-bootstrap";
import Card from "react-bootstrap/Card";
import {addMovie, addMemberToMovie} from "../../client";
import "./../../css/Explore.css";
import {UserContext} from "../general/UserContext";

const { Search } = Input;

const Explore = () => {
    const { user } = useContext(UserContext);
    const API_KEY = "ba1855b1";
    const [searchResult, setSearchResult] = useState(null);
    const [query, setQuery] = useState("");
    const [theMovie, setTheMovie] = useState({});
    const isFirstRender = useRef(true);

    const movie = {
        imdb_id: "",
        title: "",
        year: 0,
        watched_id: 0
    };

    useEffect(() => {
        if (isFirstRender.current)
            isFirstRender.current = false;
        else
            addMemberToMovie(theMovie.imdb_id, user.member_id)
    }, [theMovie]);

    const addMovieOrTvShow = result => {
        if (result.Type === "movie") {
            movie.imdb_id = result.imdbID;
            movie.title = result.Title;
            movie.year = result.Year;
            addMovie(movie)
                .then(res => res.json())
                .then(data => setTheMovie(data));
        }
        else if (result.Type === "series") {
        }
    }

    useEffect(() => {
        console.log(query)
        const getSearchResult = async () => {
            const resultFromOMDB = await fetchSearchResult();
            setSearchResult(resultFromOMDB.Search);
        }

        getSearchResult();
    }, [query]);

    const fetchSearchResult = async () => {
        const res = await fetch(`https://www.omdbapi.com/?s=${query}&apikey=${API_KEY}`);
        const data = await res.json();

        return data;
    };

    const searchFunction = (
        <Search placeholder="Search WatchTime" onSearch={value => setQuery(value)} enterButton />
    );


    return (
        <div className="view">
        <div style={{margin: "5rem"}}>
            {searchFunction}
            <div className="search_list">
                <h5>Result</h5>
                <Row xs={1} md={6} className="g-4">
                    {searchResult != null && searchResult.length > 0 && searchResult.map((result, index) => (
                        <Col
                            key={index}
                            style={{padding: "0"}}
                        >
                            {Array.from({ length: 1 }).map((_, idx) => (
                                <div className="container"
                                style={{position: "relative"}}>
                                    <Card
                                        style={{
                                            borderRadius: "5px",
                                            height: "auto",
                                            width: "auto",
                                            marginRight: "2rem",
                                            background: "none",
                                        }}
                                    >
                                <AiOutlinePlusSquare onClick={() => {addMovieOrTvShow(result)}} size={35} color={"var(--primary-color)"}
                                                     style={{
                                                         background: "rgba(211, 211, 211, 0.3)",
                                                         position: "absolute",
                                                         zIndex: "1",
                                                         cursor: "pointer",
                                                         top: "10%",
                                                         left: "85%",
                                                         transform: "translate(-50%, -50%)",
                                                        }}/>
                                        <Card.Img
                                            style={{
                                                height: "100%",
                                                width: "100%",
                                            }}
                                            variant="top"
                                            alt={result && result.Title}
                                            src={result && result.Poster}
                                            /*onClick={setShowDetail}*/
                                        />
                                        <button className="button">{result.Title}</button>
                                    </Card>
                                </div>
                            ))}
                        </Col>
                    ))}
                </Row>
            </div>
        </div>
        </div>
    );
}

export default Explore;
