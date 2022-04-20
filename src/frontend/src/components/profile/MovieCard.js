
import React, {useContext, useEffect, useState} from "react";
import {Modal} from "antd";
import MovieDetail from "./MovieDetail";
import ColCardBox from "./ColCardBox";
import 'antd/dist/antd.css';

const MovieCard = ({childToParent, imdbId, watched, movieId}) => {
    const API_KEY = "ba1855b1";
    const [movie, setMovie] = useState(null);
    const [activateModal, setActivateModal] = useState(false);
    const [detail, setShowDetail] = useState(false);
    const [detailRequest, setDetailRequest] = useState(false);

    const onCancel = () => {
        childToParent(true)
        setActivateModal(false);
    }

    useEffect(() => {
        const getPosts = async () => {
            const movieFromOMDB = await fetchMovie();
            setMovie(movieFromOMDB);
        };

        getPosts();
    }, []);


    const fetchMovie = async () => {
        const res = await fetch(`https://www.omdbapi.com/?i=${imdbId}&apikey=${API_KEY}`)
        const data = await res.json();

        return data;
    };

    return (
        <div>
            <ColCardBox
                ShowDetail={setShowDetail}
                DetailRequest={setDetailRequest}
                ActivateModal={setActivateModal}
                {...movie}
            />
            <Modal
                centered
                visible={activateModal}
                onCancel={() => setActivateModal(false)}
                footer={null}
                width={900}
            >
                { detailRequest === false ?
                    (<MovieDetail
                        childToParent={onCancel}
                        watched={watched}
                        movieId={movieId}
                        {...detail} />) :
                    <></>
                }
            </Modal>
        </div>
    );
}

export default MovieCard;