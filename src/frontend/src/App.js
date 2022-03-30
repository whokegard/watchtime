import "./App.css";
import { getAMember } from "./client";
import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Routes, Link, Route } from "react-router-dom";
import Header from "./components/general/Header";
import Footer from "./components/general/Footer";
import SignIn from "./components/sign_in/SignIn";
import Home from "./components/home/Home";
import { LoggedInContext } from "./components/general/LoggedInContext";
import { UserContext } from "./components/general/UserContext";

function App() {
    const [user, setUser] = useState({});
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    getAMember()
        .then(res => res.json())
        .then(console.log)

    return (
        <Router>
            <div className="App">
                <LoggedInContext.Provider value={{ isLoggedIn, setIsLoggedIn }}>
                    <UserContext.Provider value={{ user, setUser }}>
                        <Header />
                        <Routes>
                            <Route
                                path="/"
                                element={
                                    <>
                                        <Home />
                                    </>
                                }
                            />
                            <Route
                                path="/signin"
                                element={
                                    <>
                                        <SignIn />
                                    </>
                                }
                            />
                        </Routes>
                        <Footer />
                </UserContext.Provider>
            </LoggedInContext.Provider>
            </div>
        </Router>
  );
}

export default App;
