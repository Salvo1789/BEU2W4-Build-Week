import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useSelector } from "react-redux";

const SiteNavbar = () => {

    const userCurrent = useSelector(state => state.auth.userData)
    return(
        <Navbar expand="lg" className="bg-body-dark">
      <Container >
        <Navbar.Brand href="/">
        <img src="https://images-workbench.99static.com/DHwKtiK8HVDsHscT9XSSiQL3sNk=/http://s3.amazonaws.com/projects-files/163/16330/1633044/2917b17e-1a97-4ecd-85c7-d99955dfc71b.jpg" alt="" width="30" height="30" class="d-inline-block align-top"/>
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            {userCurrent ? (
              <Nav.Link href="#" style={{ background: "linear-gradient(brown, beige)", border: "solid", borderRadius: "5px" }}>Bentornato, {userCurrent.username}</Nav.Link>
            
            ) : (
              <Nav.Link href="/login" style={{ background: "linear-gradient(brown, beige)", border: "solid", borderRadius: "5px" }}>Login</Nav.Link>
            )}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
//         <nav class="navbar navbar-light bg-light">
//   <a class="navbar-brand" href="#">
//     <img src="https://images-workbench.99static.com/DHwKtiK8HVDsHscT9XSSiQL3sNk=/http://s3.amazonaws.com/projects-files/163/16330/1633044/2917b17e-1a97-4ecd-85c7-d99955dfc71b.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
//     Bootstrap
//   </a>
// </nav>
    )
}

export default SiteNavbar