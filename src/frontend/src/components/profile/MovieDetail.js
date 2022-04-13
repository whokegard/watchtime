import React from "react";
import {Col, Row, Tag} from "antd";

const MovieDetail = ({Title, Poster, imdbId, imdbRating, Rated, Runtime, Genre, Plot}) => {
    return (
        <Row>
            <Col span={11}>
                <img
                    src={Poster === 'N/A' ? 'https://placehold.it/198x264&text=Image+Not+Found' : Poster}
                    alt={Title}
                />
            </Col>
            <Col span={13}>
                <Row>
                    <Col span={21}>
                        <h5>{Title}</h5></Col>
                    <Col span={3} style={{textAlign: 'right'}}>
                        <h5><span style={{color: '#41A8F8'}}>{imdbRating}</span></h5>
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
            </Col>
        </Row>
    )
}

export default MovieDetail;