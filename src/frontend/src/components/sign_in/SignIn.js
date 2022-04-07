import React, { useContext, useEffect, useState } from "react";
import {Link, useNavigate} from "react-router-dom";
import "./../../css/SignIn.css";
import { LoggedInContext } from "../general/LoggedInContext";
import { UserContext } from "../general/UserContext";
import { getMemberByUsernameAndPassword } from "../../client";

const SignIn = () => {
    const { setIsLoggedIn } = useContext(LoggedInContext);
    const { user, setUser }  = useContext(UserContext);
    const [errorMessages, setErrorMessages] = useState({});
    const [isSubmitted, setIsSubmitted] = useState(false);
    const navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const errors = {
        notFound: "Invalid Username or Password",
    };

    const getMember = () => {
        getMemberByUsernameAndPassword(username, password)
            .then(res => res.json())
            .then(data => setUser(data));
    }

    const handleSubmit = (event) => {
        //Prevent page reload
        event.preventDefault();

        getMember();

        if (user == null)
            setErrorMessages({ name: "pass", message: errors.notFound });
        else {
            setIsLoggedIn(true);
            setIsSubmitted(true);
        }
    };

    // Generate JSX code for error message
    const renderErrorMessage = (name) =>
        name === errorMessages.name && (
            <div className="error">{errorMessages.message}</div>
        );

    // JSX code for login form
    const renderForm = (
        <div className="form">
            <form onSubmit={handleSubmit}>
                <div className="input-container">
                    <label>Username</label>
                    <input className="loginForm" onChange={e => {setUsername(e.target.value)}} type="text" name="uname" required />
                    {renderErrorMessage("uname")}
                </div>
                <div className="input-container">
                    <label>Password</label>
                    <input className="loginForm" onChange={e => {setPassword(e.target.value)}} type="password" name="pass" required />
                    {renderErrorMessage("pass")}
                    <Link className="register" to="/register">Create account</Link>
                </div>
                <input type="submit" value="Login" />
                <div className="button-container"></div>
            </form>
        </div>
    );

    return (
        <div className="signin">
            <div className="login-form">
                <div className="title">Sign In</div>
                <div>{isSubmitted ? navigate("/") : renderForm}</div>
            </div>
        </div>
    );
};

export default SignIn;