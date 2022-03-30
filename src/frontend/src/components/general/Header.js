import React from "react";
import { useState } from "react";
import { Navbar, Container, Nav, Col } from "react-bootstrap";
import { Link } from "react-router-dom";
import { BiLogIn } from "react-icons/bi";
import Logout from "./Logout";
import "./../../css/Header.css";

const Header = ({ loggedIn, isLoggedIn, onLogout }) => {
    const [showSignOut, setShowSignOut] = useState(isLoggedIn ? true : false);

    const handleLogin = () => {
        setShowSignOut(!showSignOut);
    };

    const handleLogout = () => {
        setShowSignOut(!false);
    };

    return (
        <div>
            <Navbar
                className="header"
                collapseOnSelect
                fixed="top"
                expand="sm"
                bg="dark"
                variant="dark"
            >
                <Container fluid>
                    <Navbar.Brand href="/">
                        <img
                            alt="logo"
                            width="100%"
                            height="auto"
                            className="d-inline-block align-top d-none d-sm-block"
                        />
                        <img
                            alt="logo"
                            width="100%"
                            height="auto"
                            className="d-inline-block align-top d-sm-none"
                        />
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav
                            className=" nav navbar-nav ms-auto"
                            style={{ fontSize: "30px" }}
                        >
                            {!isLoggedIn ? (
                                <Link
                                    onClick={isLoggedIn && handleLogin}
                                    className="link"
                                    style={{ marginLeft: "40px" }}
                                    to="/signin"
                                >
                                    {loggedIn}
                                    <BiLogIn />
                                </Link>
                            ) : (
                                <Link
                                    to="#"
                                    onClick={isLoggedIn && handleLogin}
                                    className="link"
                                    style={{ marginLeft: "40px" }}
                                >
                                    {loggedIn}
                                    <BiLogIn />
                                </Link>
                            )}
                            {showSignOut && (
                                <Logout onClick={handleLogout} onLogout={onLogout} />
                            )}
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    );
};

export default Header;
