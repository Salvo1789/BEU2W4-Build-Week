import { Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { registerAction } from "../redux/actions";
import { useState } from "react";

const RegisterPage = () => {
  const [nome, setNome] = useState("");
  const [cognome, setCognome] = useState("");
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Submitted:", { nome, cognome, username, email, password });
    const body = {username, email, password, nome, cognome };
    dispatch(registerAction(JSON.stringify(body)));
    navigate("/");
  };
  
    return(
    <Form onSubmit={handleSubmit}>
      <h2>Register</h2>
      <Form.Group controlId="formName">
        <Form.Label>Name</Form.Label>
        <Form.Control 
            type="text"
            placeholder="Enter your name"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
        />
      </Form.Group>

      <br />
      <br />

      <Form.Group controlId="formSurname">
      <Form.Label>Surname</Form.Label>
        <Form.Control 
            type="text"
            placeholder="Enter your surname"
            value={cognome}
            onChange={(e) => setCognome(e.target.value)}
        />
      </Form.Group>

      <br />
      <br />

      <Form.Group controlId="formUsername">
      <Form.Label>Username</Form.Label>
        <Form.Control 
            type="text"
            placeholder="Enter your username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
        />
      </Form.Group>

      <br />
      <br />

      <Form.Group controlId="formEmail">
      <Form.Label>Email</Form.Label>
        <Form.Control 
            type="text"
            placeholder="Enter your email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
        />
      </Form.Group>

      <br />
      <br />

      <Form.Group controlId="formPassword">
      <Form.Label>Password</Form.Label>
        <Form.Control 
            type="text"
            placeholder="Enter your password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
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
