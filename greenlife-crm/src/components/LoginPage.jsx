import { Form, Button } from "react-bootstrap"
import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { getUserDataAction, loginAction } from "../redux/actions";

const LoginPage = () => {
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const dispatch = useDispatch();
    const navigate = useNavigate();
    
    const token = useSelector(state => state.auth.token);
    // const userCurrent = useSelector(state => state.auth.userData)

    useEffect(() => {
        if(token){
        dispatch(getUserDataAction());
        }
        
      }, [token]);
  
    //   useEffect(() => {
    //     if(userCurrent){
    //         console.log(userCurrent);
    //     navigate("/menu");
    //     }
        
    //   }, [userCurrent]);

      const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Submitted:", { email, password });
        const body = { email, password };
        dispatch(loginAction(JSON.stringify(body)));
        navigate("/menu");
      };

    return(
    
        <Form onSubmit={handleSubmit}>
            <h2>Login</h2>
            <Form.Group controlId="formEmail" id="FormEmail">
                <Form.Label>Email</Form.Label>
                <Form.Control 
                    type="email"
                    placeholder="Enter your email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
                
            </Form.Group>

            <br></br>
            <br></br>

            <Form.Group controlId="formPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control 
                    type="password"
                    placeholder="Enter your password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
            </Form.Group>

            <br></br>
            <br></br>

            <Button type="submit">
                LOGIN
            </Button>
            <Link to="/register">
                Nuovo utente? Clicca qui per registrarti.
            </Link>
        </Form>
    
    ) 
}

export default LoginPage