import Card from "react-bootstrap/Card";
import {Row, Col} from "react-bootstrap";
import React, {useEffect, useState} from "react";

const MovieCard = ({imdbId}) => {
    const API_KEY = "ba1855b1";
    const [movie, setMovie] = useState(null);
    const [activateModal, setActivateModal] = useState(false);
    const [detail, setShowDetail] = useState(false);

    useEffect(() => {
        console.log("hello")
        const getPosts = async () => {
            const movieFromOMDB = await fetchMovie();
            setMovie(movieFromOMDB);
        };

        getPosts();
    }, []);

    const MovieDetail = ({Title, Poster, imdbRating, Rated, Runtime, Genre, Plot}) => {
        return (
            <Row>
                <Col span={11}>
                    <img
                        src={movie.Poster === 'N/A' ? 'https://placehold.it/198x264&text=Image+Not+Found' : movie.Poster}
                        alt={Title}
                    />
                </Col>
                {/*<Col span={13}>
                    <Row>
                        <Col span={21}>
                            <TextTitle level={4}>{Title}</TextTitle></Col>
                        <Col span={3} style={{textAlign:'right'}}>
                            <TextTitle level={4}><span style={{color: '#41A8F8'}}>{imdbRating}</span></TextTitle>
                        </Col>
                    </Row>
                    <Row style={{marginBottom: '20px'}}>
                        <Col>
                            <Tag>{Rated}</Tag>
                            <Tag>{Runtime}</Tag>
                            <Tag>{Genre}</Tag>
                        </Col>
                    </Row>
                    <Row>
                        <Col>{Plot}</Col>
                    </Row>
                </Col>*/}
            </Row>
        )
    }

    const fetchMovie = async () => {
        const res = await fetch(`http://www.omdbapi.com/?i=${imdbId}&apikey=${API_KEY}`)
        console.log(res)
        const data = await res.json();

        return data;
    };

    return (
        <div>
            <Card
                style={{
                    borderRadius: "5px",
                    height: "auto",
                    width: "20vh",
                    background: "none",
                }}
                >
                <Card.Img
                    style={{
                        borderRadius: "5px",
                    }}
                    variant="top"
                    src={movie && movie.Poster}
                    /*onClick={setShowDetail}*/
                />
            </Card>
            {/*{
                <Modal
                title='Detail'
                centered
                visible={activateModal}
                onCancel={() => setActivateModal(false)}
                footer={null}
                width={800}
            >
                { detailRequest === false ?
                    (<MovieDetail {...detail} />) :
                    <></>
                }
            </Modal>
            }*/}
        </div>
    );
}

export default MovieCard;