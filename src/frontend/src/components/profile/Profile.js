import React, {useState, useEffect} from "react";
import {getAllOfAMembersMovies} from "../../client";
import data from "bootstrap/js/src/dom/data";
import MovieList from "./MovieList";

const Profile = () => {

    return (
        <MovieList />
    );
}

export default Profile;