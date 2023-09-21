import { GET_FATTURA } from "../actions";

const initialState = {
    content: [],
  };
  
  const fatturaReducer = (state = initialState, action) => {
    switch (action.type) {
      case GET_FATTURA:
        return {
          ...state,
          content: action.payload,
        };
      default:
        return state;
    }
  };
  
  export default fatturaReducer;