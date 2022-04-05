
import React, {useEffect, useState} from "react";
import { Input, Space } from 'antd';
import { AiOutlinePlusSquare } from 'react-icons/ai';
import {Col, Row} from "react-bootstrap";
import Card from "react-bootstrap/Card";
import {addMovie} from "../../client";
import Button from "react-bootstrap/Button"

const { Search } = Input;



const Explore = () => {
    const API_KEY = "ba1855b1";
    const [searchResult, setSearchResult] = useState(null);
    const [query, setQuery] = useState("");

    const addMovieOrTvShow = result => {
        if (result.Type === "movie") {
            addMovie(...result);
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

        getSearchResult()
        console.log(searchResult);
    }, [query]);

    const fetchSearchResult = async () => {
        const res = await fetch(`https://www.omdbapi.com/?s=${query}&apikey=${API_KEY}`);
        const data = await res.json();

        return data;
    };

    const searchFunction = (
        <Search placeholder="input search text" onSearch={value => setQuery(value)} enterButton />
    );

    return (
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
                                <div>
                                <AiOutlinePlusSquare onClick={() => {addMovieOrTvShow(result)}} size={35} color={"var(--primary-color)"}
                                                     style={{marginBottom: "-3rem",
                                                         marginLeft: "-3px",
                                                         position: "relative",
                                                         zIndex: "2",
                                                         cursor: "pointer",
                                                        marginRight: "2rem"}}/>
                                    <Card
                                        style={{
                                            borderRadius: "5px",
                                            height: "auto",
                                            width: "auto",
                                            marginRight: "2rem",
                                            background: "none",
                                        }}
                                    >
                                        <Card.Img
                                            style={{
                                                height: "100%",
                                                width: "100%",
                                            }}
                                            variant="top"
                                            src={result && result.Poster}
                                            /*onClick={setShowDetail}*/
                                        />
                                    </Card>
                                </div>
                            ))}
                        </Col>
                    ))}
                </Row>
            </div>
        </div>
    );
}

export default Explore;
