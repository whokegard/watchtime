import React from "react";
import { Row, Col } from "react-bootstrap";
import Card from "react-bootstrap/Card";
import "./../../css/Cards.css";

const Cards = () => {
    const API_KEY = 'ce762116';
    const cards = [
        {
            id: 1,
            src: "",
            title: "Insurance",
            text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquet ipsum urna mauris integer eleifend quam neque.",
        },
        {
            id: 2,
            src: "",
            title: "Valuation",
            text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquet ipsum urna mauris integer eleifend quam neque.",
        },
        {
            id: 3,
            src: "",
            title: "Bidding",
            text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquet ipsum urna mauris integer eleifend quam neque.",
        },
        {
            id: 4,
            src: "",
            title: "Research suburbs",
            text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquet ipsum urna mauris integer eleifend quam neque.",
        },
        {
            id: 5,
            src: "",
            title: "We do home loans",
            text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquet ipsum urna mauris integer eleifend quam neque.",
        },
        {
            id: 6,
            src: "",
            title: "Track your property",
            text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquet ipsum urna mauris integer eleifend quam neque.",
        },
    ];
    return (
        <Row xs={1} md={3} className="g-4">
            {cards.map((card) => (
                <Col
                    key={card.id}
                    style={{
                        padding: "2rem",
                    }}
                >
                    {Array.from({ length: 1 }).map((_, idx) => (
                        <Card
                            key={card.id}
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
};

export default Cards;
