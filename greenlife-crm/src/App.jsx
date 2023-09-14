import React from 'react';
import { Container }from 'react-bootstrap';
import LoginPage from './components/LoginPage';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import RegisterPage from './components/RegisterPage';
import UserMenu from './components/UserMenu';
import CustomersList from './components/CustomersList';
import InvoicesList from './components/InvoicesList';


function App() {
  return (
    <Container>
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<LoginPage />}/>
        <Route path="/register" element={<RegisterPage />}/>
        <Route path="/menu" element={<UserMenu />} />
        <Route path="/clienti" element={<CustomersList />} />
        <Route path="/fatture" element={<InvoicesList />} />
      </Routes>
      </BrowserRouter>
    </Container>
  );
}

export default App;
