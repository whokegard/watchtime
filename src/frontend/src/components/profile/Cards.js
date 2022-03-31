import React, {useEffect, useState} from "react";
import { Row, Col} from "react-bootstrap";
import {getAMembersMovies} from "../../client";

const Cards = () => {
  const [movies, setMovies] = useState([]);

  const fetchAMembersMovies = () => getAMembersMovies()
      .then(res => res.json())
      .then(data => setMovies(data));

  useEffect(() => {
    fetchAMembersMovies();
  }, []);


  return (
      <Row xs={1} md={6} className="g-4">
        {movies.map((movie) => (
            <Col
                key={movie.id}
                style={{
                  padding: "2rem",
                }}
            >
              {Array.from({ length: 1 }).map((_, idx) => (
                  <Card
                      key={movie.id}
                      className="card__service"
                      style={{
                        border: "none",
                        borderRadius: "20px",
                      }}
                  >
                    <Card.Img
                        style={{
                          borderTopLeftRadius: "20px",
                          borderTopRightRadius: "20px",
                        }}
                        variant="top"
                        src={card.src}
                    />
                    <Card.Body>
                      <Card.Title>{card.title}</Card.Title>
                      <Card.Text>{card.text}</Card.Text>
                    </Card.Body>
                  </Card>
              ))}
            </Col>
        ))}
      </Row>
  );
}

export default Cards;