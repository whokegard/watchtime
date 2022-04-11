import React, {useState, useEffect} from "react";
import data from "bootstrap/js/src/dom/data";
import MovieList from "./MovieList";
import TVShowList from "./TVShowList";

const Profile = () => {

    return (
        <div className="profile">
        <MovieList />
        <TVShowList />
        </div>
    );
}

export default Profile;