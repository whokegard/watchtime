import React, {useContext, useState} from "react";
import {Col, Row, Tag, Typography } from "antd";
import {PlusCircleOutlined, CheckCircleOutlined, MinusCircleOutlined} from "@ant-design/icons";
import {addMovieToWatchedList, removeMovieFromWatchedList, removeMovie} from "../../client";
import {UserContext} from "../general/UserContext";

const TextTitle = Typography.Title;

const MovieDetail = ({childToParent, watched, movieId, Title, Poster, imdbRating, Rated, Runtime, Genre, Plot}) => {
    const { user }  = useContext(UserContext);

    const onAdd = () => {
        addMovieToWatchedList(user.member_id, movieId)
            .then(res => res.json())
            .then(data => console.log(data));

        childToParent(true);
    }

    const onRemove = () => {
        removeMovieFromWatchedList(user.member_id, movieId)
            .then(res => res.json())
            .then(data => console.log(data));

        childToParent(true);
    }

    const onDelete = () => {
        removeMovie(user.member_id, movieId)
            .then(res => res.json())
            .then(data => console.log(data));

        childToParent(true);
    }

    return (
        <Row style={{marginTop: "2rem", marginBottom: "2rem"}}>
            <Col span={11}>
                <img
                    src={Poster === 'N/A' ? 'https://placehold.it/198x264&text=Image+Not+Found' : Poster}
                    alt={Title}
                />
            </Col>
            <Col span={13}>
                <Row>
                    <Col span={21}>
                        <TextTitle>{Title}</TextTitle></Col>
                    <Row>
                        { watched
                            ? <CheckCircleOutlined
                                onClick={() => onRemove()}
                                style={{fontSize: "35px", cursor: "pointer", color: "green"}}
                            />
                            : <CheckCircleOutlined
                                onClick={() => onAdd()}
                                style={{fontSize: "35px", cursor: "pointer", color: "gray"}}
                            />
                        }
                        <MinusCircleOutlined onClick={() => onDelete()} style={{fontSize: "35px", cursor: "pointer", color: "red"}}/>
                    </Row>
                        {/*<PlusCircleOutlined style={{ fontSize: "35px", color: "var(--primary-color)", cursor: "pointer"}} />*/}
                    <Col span={3} style={{textAlign: 'right'}}>
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
                <Row>
                    <h5 style={{marginTop: "10px"}}><span style={{color: "var(--primary-color)", marginTop: "30px"}}>{imdbRating}/10</span></h5>
                </Row>
            </Col>
        </Row>
    )
}

export default MovieDetail;