import React, { useState } from 'react';
import PropTypes from 'prop-types';

import './Login.css';

async function loginUser(credentials) {
 return fetch('http://localhost:8080/login', {
   method: 'POST',
   headers: {
     'Content-Type': 'application/json'
   },
   body: JSON.stringify(credentials)
 })
   .then(data => data.json())
}

export default function Login({ setToken }) {

  const [username, setUserName] = useState();
  const [password, setPassword] = useState();

  const handleSubmit = async e => {
    e.preventDefault();
    const token = await loginUser({
      username,
      password
    });
    setToken(token);
    console.log(loginUser);
  }

  return(

<div className='cointainer'>
    <div className='Titlle'> 
    <h1>Sistema SPC</h1>
    </div>
    <div className="login">
      <img src="https://universidadedevassouras.edu.br/wp-content/uploads/2021/12/logo_horizontal_univasso.svg" className='log-img'></img>
      <h1>Log In</h1>
      <form onSubmit={handleSubmit}>
        <label>
          <p>Username</p>
          <input type="text" onChange={e => setUserName(e.target.value)} />
        </label>
        <label>
          <p>Password</p>
          <input type="password" onChange={e => setPassword(e.target.value)} />
        </label>
        <div className='btn-logar'>
          <button  className='btn-primary' type="submit">Submit</button>
        </div>
      </form>
    </div>
  </div>
  )
}

Login.propTypes = {
  setToken: PropTypes.func.isRequired
};