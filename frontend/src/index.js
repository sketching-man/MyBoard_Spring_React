import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import App from './App.js';
import { Memberlist_frame } from './components/memberlist_frame.js';


ReactDOM.render(
    <Router>
      <Routes>
        <Route path='/' element={<App />} />
        <Route path='/members' element={<Memberlist_frame />} />
      </Routes>
    </Router>,
  document.getElementById('root')
)

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
