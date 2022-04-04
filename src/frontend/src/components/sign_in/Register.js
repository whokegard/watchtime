import React, { useContext, useEffect, useState } from "react";
import {Link, useNavigate} from "react-router-dom";
import "./../../css/SignIn.css";
import { LoggedInContext } from "../general/LoggedInContext";
import { UserContext } from "../general/UserContext";
import { registerAMember } from "../../client";

const Register = () => {
    const { setIsLoggedIn } = useContext(LoggedInContext);
    const { setUser } = useContext(UserContext);
    const [users, setUsers] = useState([]);
    const [errorMessages, setErrorMessages] = useState({});
    const [isSubmitted, setIsSubmitted] = useState(false);
    const navigate = useNavigate();


    const finished = values => {
        console.log("hello")
        console.log(JSON.stringify(values, null, 2))
    }

    const handleSubmit = (event, member) => {
        //Prevent page reload
        finished();
        event.preventDefault();
        registerAMember(member);
        setIsSubmitted(true);

        var { uname, pass } = document.forms[0];

        // Find user login info
        const userData = users.find((user) => user.username === uname.value);

        // Compare user info
        if (userData) {
            if (userData.password !== pass.value) {
                // Invalid password

                setErrorMessages({ name: "pass" });
            } else {
            }
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
                    <label>First name</label>
                    <input className="loginForm" type="text" name="first_name" required />
                </div>
                <div className="input-container">
                    <label>Last name</label>
                    <input className="loginForm" type="text" name="last_name" required />
                </div>
                <div className="input-container">
                    <label>E-mail</label>
                    <input className="loginForm" type="text" name="email" required />
                </div>
                <div className="input-container">
                    <label>Username</label>
                    <input className="loginForm" type="text" name="username" required />
                </div>
                <div className="input-container">
                    <label>Password</label>
                    <input className="loginForm" type="text" name="password" required />
                    {renderErrorMessage("pass")}
                </div>
                <div className="input-container">
                    <Link className="register" to ="/signin">Already have an account?</Link>
                </div>
                <input type="submit" value="Register" />
                <div className="button-container"></div>
            </form>
        </div>
    );

    return (
        <div className="signin">
            <div className="login-form">
                <div className="title">Register</div>
                <div>{isSubmitted ? <></> : renderForm}</div>
            </div>
        </div>
    );
};

export default Register;
