import { USER_LOGIN, USER_REGISTER, USER_LOGOUT, GET_USER_DATA } from "../actions";

const authReducer = (state = { token: null, userData: {} }, action) => {
  switch (action.type) {
    case USER_LOGIN:
      return {
        ...state,
        token: action.payload,
      };
    case USER_LOGOUT:
      return {
        ...state,
        userData: null,
        token: null,
      };
      case USER_REGISTER:
      return {
        ...state,
        token: action.payload,
      };
    case GET_USER_DATA:
      return {
        ...state,
        userData: action.payload,
      };
      default:
      return state;
  }
};

export default authReducer;