import React from 'react';
import { Container }from 'react-bootstrap';
import LoginPage from './components/LoginPage';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import RegisterPage from './components/RegisterPage';
import UserMenu from './components/UserMenu';
import CustomersList from './components/CustomersList';
import InvoicesList from './components/InvoicesList';
import InvoiceDetail from './components/InvoiceDetail';
import SiteNavbar from './components/SiteNavbar';


function App() {
  return (
    
      <BrowserRouter>
      <SiteNavbar />
      <Routes>
        <Route path="/" element={<LoginPage />}/>
        <Route path="/register" element={<RegisterPage />}/>
        <Route path="/menu" element={<UserMenu />} />
        <Route path="/clienti" element={<CustomersList />} />
        <Route path="/fatture" element={<InvoicesList />} />
        <Route path="/fatture/:id" element={<InvoiceDetail />} />
      </Routes>
      </BrowserRouter>
    
  );
}

export default App;
