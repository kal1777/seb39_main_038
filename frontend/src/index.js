import React from 'react';
import reactDOM from 'react-dom/client';
import { BrowserRouter as Router } from 'react-router-dom';
import axios from 'axios';
import './index.css';
import { RecoilRoot } from 'recoil';
import App from './App';

axios.defaults.withCredentials = true;
const root = reactDOM.createRoot(document.getElementById('root'));
root.render(
  <Router>
    <RecoilRoot>
      <App />
    </RecoilRoot>
  </Router>,
);
