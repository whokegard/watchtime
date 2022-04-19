import React, {useContext, useEffect, useRef, useState} from "react";
import { Row, Col} from "react-bootstrap";
import {getAMembersWatchedTVShows, getAMembersNonWatchedTVShows} from "../../client";
import { UserContext } from "../general/UserContext";
import TVShowCard from "./TVShowCard";
import "../../css/TVShowList.css";

const TVShowList = () => {
  const [watchedTvShows, setWatchedTvShows] = useState([]);
  const [nonWatchedTvShows, setNonWatchedTvShows] = useState([]);
  const { user } = useContext(UserContext);

    const childToParent = () => {

        setWatchedTvShows([]);
        setNonWatchedTvShows([]);
            fetchAMembersWatchedTVShows();
            fetchAMembersNonWatchedTVShows();
        console.log("do");
    };

  const fetchAMembersWatchedTVShows = () => getAMembersWatchedTVShows(user.member_id)
      .then(resp => resp)
      .then(res => res.json())
      .then(data => {
        setWatchedTvShows(data);
        console.log(data);
          console.log("hello");
      });

  useEffect(() => {
      fetchAMembersWatchedTVShows();
      fetchAMembersNonWatchedTVShows();
      console.log("yello");
  }, []);

  const fetchAMembersNonWatchedTVShows = () => getAMembersNonWatchedTVShows(user.member_id)
      .then(resp => resp)
      .then(res => res.json())
      .then(data => {
        setNonWatchedTvShows(data);
        console.log(data);
          console.log("bye");
      });


  return (
      <div className="tvshow_list">
          <h5>Not Watched TV-Shows</h5>
          <Row xs={1} md={6} className="g-4">
              {nonWatchedTvShows.map((tvShow, index) => (
                  <Col
                      key={index}
                      style={{padding: "0"}}
                  >
                      {Array.from({ length: 1 }).map((data, index) => (
                          <TVShowCard
                              key={index}
                              watched={false}
                              imdbId={tvShow.imdb_id}
                              tvShowId={tvShow.tvshow_id}
                              childToParent={childToParent}
                          />
                      ))}
                  </Col>
              ))}
          </Row>
        <h5 style={{paddingTop: "2rem"}}>Watched TV-Shows</h5>
        <Row xs={1} md={6} className="g-4">
          {watchedTvShows.map((tvShow, index) => (
              <Col
                 key={index}
                 style={{padding: "0"}}
              >
               {Array.from({ length: 1 }).map((data, index) => (
                   <TVShowCard
                       key={index}
                       imdbId={tvShow.imdb_id}
                       watched={true}
                       tvShowId={tvShow.tvshow_id}
                       childToParent={childToParent}
                   />
               ))}
             </Col>
          ))}
        </Row>
      </div>


  );
}

export default TVShowList;