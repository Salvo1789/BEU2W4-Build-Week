export const GET_CLIENTI = "GET_CLIENTI";
export const GET_CLIENTE = "GET_CLIENTE";
export const CREATE_CLIENTE = "CREATE_CLIENTE";
export const MODIFY_CLIENTE = "MODIFY_CLIENTE";
export const DELETE_CLIENTE = "DELETE_CLIENTE";
export const USER_LOGIN = "USER_LOGIN";
export const USER_LOGOUT = "USER_LOGOUT";
export const USER_REGISTER = "USER_REGISTER";
export const GET_USER_DATA = "GET_USER_DATA";


//CUUSTOMERS ACTIONS

export const getAllCustomersAction = () => {

    return async (dispatch) => {

        const endpoint = "http://localhost:3001/clienti";

        try{
            const resp = await fetch(endpoint);
            if (resp.ok){
                const customersData = await resp.json();
                dispatch({type: GET_CLIENTI, payload: customersData});
            }else{
                alert("Errore: qualcosa è andato storto.")
            }
        }catch(error){
            console.log(error);
        }

    }
}

export const getCustomerAction = (id) => {
    return async (dispatch) => {
      
  
      const endpoint = "http://localhost:3001/clienti/" + id;
      
      console.log(endpoint);
      try {
        const resp = await fetch(endpoint);
        if (resp.ok) {
          const customerData = await resp.json();
          dispatch({ type: GET_CLIENTE, payload: customerData });
        } else {
          alert("Errore qualcosa è andato storto");
        }
      } catch (error) {
        console.log(error);
      }
    };
  };

  export const createCustomerAction = savedCustomer => {
    return async (dispatch, getState) => {
      const token = getState().auth.token;
      try {
        let resp = await fetch("http://localhost:3001/clienti", {
          method: "POST",
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
          body:JSON.stringify(savedCustomer),
        });
        if (resp.ok) {
          let newCustomerData = await resp.json();
          dispatch({ type: CREATE_CLIENTE, payload: newCustomerData});
        } else {
          console.log("error");
        }
      } catch (error) {
        console.log(error);
      } finally {
        console.log("fetch loading finish");
      }
    };
  }

  //AUTH ACTIONS

  export const loginAction = (body) => {
    return async (dispatch) => {
      try {
        let resp = await fetch("http://localhost:3001/auth/login", {
          method: "POST",
          headers: {
            //Authorization: AUTHORIZATION,
            "Content-Type": "application/json",
          },
          body,
        });
        if (resp.ok) {
          let data = await resp.json();
          dispatch({ type: USER_LOGIN, payload: data.accessToken });
        } else {
          console.log("error");
        }
      } catch (error) {
        console.log(error);
      } finally {
        console.log("fetch loading finish");
      }
    };
  };
  
  export const registerAction = (body) => {
    return async (dispatch) => {
      try {
        let resp = await fetch("http://localhost:3001/auth/register", {
          method: "POST",
          headers: {
            //Authorization: AUTHORIZATION,
            "Content-Type": "application/json",
          },
          body,
        });
        if (resp.ok) {
          let data = await resp.json();
          dispatch({ type: USER_REGISTER, payload: data });
        } else {
          console.log("error");
        }
      } catch (error) {
        console.log(error);
      } finally {
        console.log("fetch loading finish");
      }
    };
  };
  
  export const getUserDataAction = () => {
    return async (dispatch, getState) => {
      const token = getState().auth.token;
      try {
        let resp = await fetch("http://localhost:3001/users/me", {
          //   method: "POST",
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
          //   body,
        });
        if (resp.ok) {
          let data = await resp.json();
          dispatch({ type: GET_USER_DATA, payload: data });
        } else {
          console.log("error");
        }
      } catch (error) {
        console.log(error);
      } finally {
        console.log("fetch loading finish");
      }
    };
  };
  
  export const logoutAction = () => ({ type: USER_LOGOUT });
