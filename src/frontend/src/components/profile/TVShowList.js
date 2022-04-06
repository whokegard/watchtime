import React, {useEffect, useState} from "react";
import { Row, Col} from "react-bootstrap";
import {getAllOfAMembersSeries} from "../../client";
import MovieCard from "./MovieCard";
import "../../css/MovieList.css";

const TVShowList = () => {
    const [series, setSeries] = useState([]);

    const fetchAMembersSeries = () => getAllOfAMembersSeries()
        .then(resp => resp)
        .then(res => res.json())
        .then(data => setSeries(data));

    useEffect(() => {
        fetchAMembersSeries();
    }, [series]);


    return (
        <div className="series_list">
            <h5>TV-Series</h5>
            <Row xs={1} md={6} className="g-4">
                {series.map((series, index) => (
                    <Col
                        key={index}
                        style={{padding: "0"}}
                    >
                        {Array.from({ length: 1 }).map((_, idx) => (
                            <MovieCard key={series.series_id} imdbId={series.imdb_id}/>
                        ))}
                    </Col>
                ))}
            </Row>
        </div>


    );
}

export default TVShowList;