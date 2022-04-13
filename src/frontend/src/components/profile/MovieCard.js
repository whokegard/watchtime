
import React, {useEffect, useState} from "react";
import {Modal} from "antd";
import MovieDetail from "./MovieDetail";
import ColCardBox from "./ColCardBox";
import 'antd/dist/antd.css';

const MovieCard = ({imdbId}) => {
    const API_KEY = "ba1855b1";
    const [movie, setMovie] = useState(null);
    const [activateModal, setActivateModal] = useState(false);
    const [detail, setShowDetail] = useState(false);
    const [detailRequest, setDetailRequest] = useState(false);

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
                title='Detail'
                centered
                visible={activateModal}
                onCancel={() => setActivateModal(false)}
                width={800}
                style={{background: "#fff", width: "900px"}}
            >
                { detailRequest === false ?
                    (<MovieDetail {...detail} />) :
                    <></>
                }
            </Modal>
        </div>
    );
}

export default MovieCard;