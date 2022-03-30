import "./App.css";
import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Routes, Link, Route } from "react-router-dom";
import Header from "./components/general/Header";
import Footer from "./components/general/Footer";
import SignIn from "./components/sign_in/SignIn";
import Home from "./components/home/Home";

function App() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [username, setUsername] = useState("");
    const loggedIn = isLoggedIn ? username : "Sign In";

    const childToParent = (childData) => {
        setIsLoggedIn(true);
        setUsername(childData);
    };

    const logout = () => {
        setIsLoggedIn(false);
        setUsername(loggedIn);
    };

    return (
        <Router>
            <div className="App">
                <Header
                    childToParent={childToParent}
                    onLogout={logout}
                    loggedIn={loggedIn}
                    isLoggedIn={isLoggedIn}
                />
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
                                <SignIn childToParent={childToParent} />
                            </>
                        }
                    />
                </Routes>
                <Footer />
            </div>
        </Router>
  );
}

export default App;
