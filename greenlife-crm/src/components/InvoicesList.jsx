import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { getAllInvoicesAction } from "../redux/actions";

const InvoicesList = () => {
  const invoices = useSelector((state) => state.fatture.content);
  const dispatch = useDispatch();

  const userCurrent = useSelector((state) => state.auth.userData);

  useEffect(() => {
    dispatch(getAllInvoicesAction());

    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <table style={{ minWidth: "100%", border: "2px solid brown" }} class="table">
          <thead>
            <tr>
              <th scope="col">Numero</th>
              <th scope="col">Anno</th>
              <th scope="col">Data</th>
              <th scope="col">Importo</th>
              <th scope="col">Stato</th>
            </tr>
          </thead>
          <tbody>
    {invoices &&
    invoices.content.map((invoice) => (
      <>
            <tr style={{ border: "2px solid brown" }}>
          <td>
            {invoice.numero}
          </td>
          <td>{invoice.anno}</td>
          <td>{invoice.data}</td>
          <td>{invoice.importo}</td>
          <td>
            {invoice.stato}
          </td>
          </tr>
      </>
    ))}
    </tbody>
  </table>
  );
};

export default InvoicesList