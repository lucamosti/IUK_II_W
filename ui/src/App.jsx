import React from 'react';
import './book/Books.jsx'

import logo from './book.svg';
import './App.css';
import Books from "./book/Books.jsx";
import CreateBook from "./book/CreateBook.jsx";
import Home from "./Home.jsx";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";

export default function App() {
    return (
        <div className="App">
            <Router>
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo" />
                    <p>Welcome to our Book store.</p>
                    <nav><Link to="/">Home</Link> | <Link to="/books">Books</Link> | <Link to="/create">Create Book</Link></nav>
                </header>
                {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
                <Switch>
                    <Route path="/books">
                        <Books />
                    </Route>
                    <Route path="/create">
                        <CreateBook />
                    </Route>
                    <Route path="/">
                        <Home />
                    </Route>
                </Switch>
            </Router>
        </div>
    );
}

