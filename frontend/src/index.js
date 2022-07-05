import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

// import App from './App.js';
import { BoardFrame } from './components/board_frame';
import { MemberlistFrame } from './components/memberlist_frame.js';
import { Article } from './components/article.js';
import { Member } from './components/member.js';


ReactDOM.render(
  <Router>
    <Routes>
      
      <Route exact path='/' element={<BoardFrame />} />
      <Route path='/:id' element={<Article />} />

      <Route exact path='/members' element={<MemberlistFrame />} />
      <Route path='/members/:id' element={<Member />} />

    </Routes>
  </Router>,
  document.getElementById('root')
)

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
