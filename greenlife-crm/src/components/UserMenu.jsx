import { Container, Row, Col, Card, Button } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import { useSelector } from "react-redux";

const UserMenu = () => {

  // const userCurrent = useSelector(state => state.auth.userData)

    return (
      <>
    <Container>
      <Row>
    <Col>
      <Card style={{ width: "18rem" }}>
        <Card.Img id="img1" variant="top" src="https://images.pexels.com/photos/5816293/pexels-photo-5816293.jpeg" />
        <Card.Body>
          <Card.Title>Lista Clienti</Card.Title>
          <Link id="link1" to="/clienti">
            <Button>Consulta</Button>
          </Link>
        </Card.Body>
      </Card>
    </Col>
    <Col>
      <Card style={{ width: "18rem" }}>
        <Card.Img id="img2" variant="top" src="https://images.pexels.com/photos/1764956/pexels-photo-1764956.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" />
        <Card.Body>
          <Card.Title>Lista Fatture</Card.Title>
          <Link id="link2" to="/fatture">
            <Button>Consulta</Button>
          </Link>
        </Card.Body>
      </Card>
    </Col>
  </Row>
  </Container>
  </>
    )
};

export default UserMenu;
