import React, {useContext} from "react";
import MovieList from "./TVShowList";
import TVShowList from "./MovieList";
import {LoggedInContext} from "../general/LoggedInContext";

const Profile = () => {
    const { isLoggedIn } = useContext(LoggedInContext);

    return (
            <div className={"view"}>
                {isLoggedIn ?
                    <div>
                        <MovieList/>
                        <TVShowList/>
                    </div>
                    :
                    <></>
                }
            </div>
    );
}

export default Profile;