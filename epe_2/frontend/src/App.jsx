import React, { useContext } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Headers from "./components/Headers";
import Footers from "./components/Footers";
import Home from "./components/Home";
import SideNav from "./components/SideNav";
import Reportes from './pages/Reportes';
import Login from './components/Login';
import { AuthProvider, AuthContext } from './AuthContext';

const AppContent = () => {
  const { isAuthenticated } = useContext(AuthContext);

  if (!isAuthenticated) {
    return (
      <Routes>
        <Route path="/login" element={<Login />} />
        {/* <Route path="*" element={<Navigate to="/login" />} /> */}
      </Routes>
    );
  }

  return (
    <>
      <SideNav />
      <Headers />
      <div className="main-content">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/:path/:idReport/*" element={<Reportes />} />
        </Routes>
      </div>
    </>
  );
};

const App = () => {
  return (
    <AuthProvider>
      <Router>
        <AppContent />
        <Footers />
      </Router>
    </AuthProvider>
  );
}

export default App;
