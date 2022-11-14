import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css';

const scp_login = ReactDOM.createRoot(document.getElementById('scp_login'));
scp_login.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);