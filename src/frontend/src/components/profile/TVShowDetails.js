import React from "react";
import {Container} from "react-bootstrap";

const CalCardBox = ({title, poster, genre, year, runtime, plot, imdbRating, imdbVotes, totalSeasons, episodes}) => {
    return (
        <Container>
            <div className="post__info">
                <h1>{title}</h1>
                <h5>{year}</h5>
                <h5>{genre}</h5>
                <h5>{runtime}</h5>
                <h5>{imdbRating}</h5>
                <h5>{imdbVotes}</h5>
                <h5>{totalSeasons}</h5>
                <h5>{episodes}</h5>
                <p>{plot}</p>
            </div>
            <img className="postImg" src={poster} alt="series poster" />
        </Container>
    );
}

export default CalCardBox;