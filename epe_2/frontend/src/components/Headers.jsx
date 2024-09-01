import React, { useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../AuthContext'; // Ajusta la ruta según la ubicación real de AuthContext

const Headers = () => {
  const navigate = useNavigate();
  const { setAuth } = useContext(AuthContext);

  const handleLogout = () => {
    localStorage.removeItem('token');
    setAuth(false);
    navigate('/login');
  };

  return (
    <div>
      <nav className="main-header navbar navbar-expand navbar-white navbar-light">
        <ul className="navbar-nav"></ul>
        <ul className="navbar-nav ml-auto">
          <button className='btn btn-primary' onClick={handleLogout}>Logout</button>
        </ul>
      </nav>
    </div>
  );
};

export default Headers;
