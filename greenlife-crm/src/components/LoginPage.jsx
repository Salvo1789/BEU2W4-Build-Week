import { Container, Form, Button } from "react-bootstrap"
import { Link } from 'react-router-dom'

const LoginPage = () => {

    

    return(
    <Container id="LoginContainer">
        <Form id="LoginForm">
            <h2>Login</h2>
            <Form.Group controlId="formEmail" id="FormEmail">
                <Form.Label>Email</Form.Label>
                <Form.Control 
                    type="email"
                    placeholder="Enter your email"
                />
                
            </Form.Group>

            <br></br>
            <br></br>

            <Form.Group controlId="formPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control 
                    type="password"
                    placeholder="Enter your password"
                />
            </Form.Group>

            <br></br>
            <br></br>

            <Button type="submit">
                LOGIN
            </Button>
            {/* <Link to="#">
                Nuovo utente? Clicca qui per registrarti.
            </Link> */}
        </Form>
    </Container>
    ) 
}

export default LoginPage