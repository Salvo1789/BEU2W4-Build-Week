import { GET_FATTURE } from "../actions";

const initialState = {
    content: null
}

const clientiReducer = (state = initialState, action) => {
    switch (action.type) {
      case GET_FATTURE:
        return {
          ...state,
          content: action.payload,
        };
      default:
        return state;
    }
  };

  export default clientiReducer