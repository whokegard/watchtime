import React, { useState } from "react";
import ReactDOM from "react-dom";
import { useNavigate } from "react-router-dom";
import Home from "../home/Home";
import "./../../css/SignIn.css";

const SignIn = ({ childToParent }) => {
    const [errorMessages, setErrorMessages] = useState({});
    const [isSubmitted, setIsSubmitted] = useState(false);
    const [username, setUsername] = useState("");
    const navigate = useNavigate();

    // User Login info
    const database = [
        {
            username: "love",
            password: "admin",
        },
        {
            username: "benjamin",
            password: "admin",
        },
        {
            username: "sebastian",
            password: "admin",
        },
        {
            username: "william",
            password: "admin",
        },
    ];

    const errors = {
        uname: "Invalid Username",
        pass: "Invalid Password",
    };

    const handleSubmit = (event) => {
        //Prevent page reload
        event.preventDefault();

        var { uname, pass } = document.forms[0];

        // Find user login info
        const userData = database.find((user) => user.username === uname.value);

        // Compare user info
        if (userData) {
            if (userData.password !== pass.value) {
                // Invalid password

                setErrorMessages({ name: "pass", message: errors.pass });
            } else {
                childToParent(username);
                setIsSubmitted(true);
            }
        } else {
            // Username not found
            setErrorMessages({ name: "uname", message: errors.uname });
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
                    <input
                        className="loginForm"
                        onChange={(e) => setUsername(e.target.value)}
                        type="text"
                        name="uname"
                        required
                    />
                    {renderErrorMessage("uname")}
                </div>
                <div className="input-container">
                    <label>Password</label>
                    <input className="loginForm" type="password" name="pass" required />
                    {renderErrorMessage("pass")}
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
