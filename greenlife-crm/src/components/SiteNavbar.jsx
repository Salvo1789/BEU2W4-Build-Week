import { Dropdown } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
import { logoutAction, getUserDataAction } from "../redux/actions";

const SiteNavbar = () => {
  const userCurrent = useSelector((state) => state.auth.userData);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  useEffect(() => {
    dispatch(getUserDataAction());
    
    
  }, []);

  return (
    <nav class="navbar navbar-light bg-light">
      <img id="logo"
        src="https://images-workbench.99static.com/DHwKtiK8HVDsHscT9XSSiQL3sNk=/http://s3.amazonaws.com/projects-files/163/16330/1633044/2917b17e-1a97-4ecd-85c7-d99955dfc71b.jpg"
        width="100"
        height="100"
        class="d-inline-block align-top"
        alt="logo"
      />
      <a class="navbar-brand" href="#">
        {userCurrent && (
          <Dropdown>
            <Dropdown.Toggle variant="success" id="dropdown-basic">
              Benvenuto, {userCurrent.username}
            </Dropdown.Toggle>

            <Dropdown.Menu>
              <Dropdown.Item onClick={() => {
                      dispatch(logoutAction());
                      navigate("/");
                      // sto dispatchando un'action creator
                      // è la stessa cosa che dispatchare l'action
                      // perchè l'action creator è una funzione che torna l'action
                    }}>Logout</Dropdown.Item>
            </Dropdown.Menu>
          </Dropdown>
        )}
      </a>
    </nav>
  );
};

export default SiteNavbar;
