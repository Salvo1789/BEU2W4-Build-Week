import { GET_CLIENTI } from "../actions";

const initialState = {
    content: []
}

const clientiReducer = (state = initialState, action) => {
    switch (action.type) {
      case GET_CLIENTI:
        return {
          ...state,
          content: action.payload,
        };
      default:
        return state;
    }
  };

  export default clientiReducer