import { configureStore, combineReducers } from "@reduxjs/toolkit";
import { persistStore, persistReducer } from "redux-persist";
import { encryptTransform } from "redux-persist-transform-encrypt";

import authReducer from '../reducers/authReducer';
import clientiReducer from '../reducers/clientiReducer';

import storage from "redux-persist/lib/storage";


const persistConfig = {
    key: "root",
    storage,
    transforms: [
      encryptTransform({
        secretKey: process.env.REACT_APP_PERSIST_KEY
      })
    ]
  };

  const mainReducer = combineReducers({
    auth: authReducer,
    clienti: clientiReducer
  });

  const persistedReducer = persistReducer(persistConfig, mainReducer);

  const store = configureStore({
    reducer: persistedReducer,
    middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({ serializableCheck: false })
  })

  export const persistor = persistStore(store);

  export default store;