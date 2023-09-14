import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { getAllCustomersAction } from "../redux/actions";

const CustomersList = () => {
  const customers = useSelector((state) => state.clienti.content);
  const dispatch = useDispatch();

  const userCurrent = useSelector((state) => state.auth.userData);

  useEffect(() => {
    dispatch(getAllCustomersAction());

    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
        <table style={{ border: "2px solid brown" }} class="table">
          <thead>
            <tr>
              <th scope="col">Ragione Sociale</th>
              <th scope="col">Tipo</th>
              <th scope="col">Partita IVA</th>
              <th scope="col">Email</th>
              <th scope="col">Data inserimento</th>
              <th scope="col">Data ultimo contatto</th>
            </tr>
          </thead>
          <tbody>
    {customers &&
    customers.content.map((customer) => (
      <>
            <tr style={{ border: "2px solid brown" }}>
          <td>
            {customer.ragioneSociale}
          </td>
          <td>{customer.tipo}</td>
          <td>{customer.partitaIva}</td>
          <td>{customer.email}</td>
          <td>
            {customer.dataInserimento}
          </td>
          <td>
            {customer.dataUltimoContatto}
          </td>
          </tr>
      </>
    ))}
    </tbody>
  </table>
  );
};

export default CustomersList;
