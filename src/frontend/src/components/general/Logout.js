import React, { useContext } from "react";
import { Link } from "react-router-dom";
import "./../../css/Logout.css";
import { LoggedInContext } from "./LoggedInContext";

const Logout = ({ handleLogout }) => {
    const { setIsLoggedIn } = useContext(LoggedInContext);

    const onLogout = () => {
        setIsLoggedIn(false);
    };

    return (
        <div className="logout">
            <Link
                onClick={{ handleLogout, onLogout }}
                className="logout__link"
                to="/signin"
            >
                Sign Out
            </Link>
        </div>
    );
};

export default Logout;
