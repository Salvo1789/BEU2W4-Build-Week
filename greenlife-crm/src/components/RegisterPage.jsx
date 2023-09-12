import { Button, Form } from "react-bootstrap";

const RegisterPage = () => {
  
    return(
    <Form>
      <h2>Register</h2>
      <Form.Group controlId="formName">
        <Form.Label>Name</Form.Label>
        <Form.Control 
            type="text"
            placeholder="Enter your name"
        />
      </Form.Group>

      <br />
      <br />

      <Form.Group controlId="formSurname">
      <Form.Label>Surname</Form.Label>
        <Form.Control 
            type="text"
            placeholder="Enter your surname"
        />
      </Form.Group>

      <br />
      <br />

      <Form.Group controlId="formUsername">
      <Form.Label>Username</Form.Label>
        <Form.Control 
            type="text"
            placeholder="Enter your username"
        />
      </Form.Group>

      <br />
      <br />

      <Form.Group controlId="formEmail">
      <Form.Label>Email</Form.Label>
        <Form.Control 
            type="text"
            placeholder="Enter your email"
        />
      </Form.Group>

      <br />
      <br />

      <Form.Group controlId="formPassword">
      <Form.Label>Password</Form.Label>
        <Form.Control 
            type="text"
            placeholder="Enter your password"
        />
      </Form.Group>

      <br />
      <br />

      <Button type="submit" >
        REGISTER
      </Button>
    </Form>
    )
};

export default RegisterPage;
