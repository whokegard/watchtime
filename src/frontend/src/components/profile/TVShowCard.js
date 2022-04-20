
import React, {useContext, useEffect, useState} from "react";
import {Modal} from "antd";
import ColCardBox from "./ColCardBox";
import 'antd/dist/antd.css';
import TVShowDetails from "./TVShowDetails";

const TVShowCard = ({childToParent, imdbId, watched, tvShowId}) => {
    const API_KEY = "ba1855b1";
    const [tvShow, setTvShow] = useState(null);
    const [activateModal, setActivateModal] = useState(false);
    const [detail, setShowDetail] = useState(false);
    const [detailRequest, setDetailRequest] = useState(false);

    const onCancel = () => {
        childToParent(true)
        setActivateModal(false);
    }

    useEffect(() => {
        const getPosts = async () => {
            const tvShowFromOMDB = await fetchTVShow();
            setTvShow(tvShowFromOMDB);
        };

        getPosts();
    }, []);


    const fetchTVShow = async () => {
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
                {...tvShow}
            />
            <Modal
                centered
                visible={activateModal}
                onCancel={() => setActivateModal(false)}
                footer={null}
                width={900}
            >
                { detailRequest === false ?
                    (<TVShowDetails
                        childToParent={onCancel}
                        watched={watched}
                        tvShowId={tvShowId}
                        {...detail} />) :
                    <></>
                }
            </Modal>
        </div>
    );
}

export default TVShowCard;