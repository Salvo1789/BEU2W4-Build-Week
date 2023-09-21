import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { getAllInvoicesAction } from "../redux/actions";
import { Button, Container } from "react-bootstrap";
import { Link } from "react-router-dom";


const InvoicesList = () => {
  const invoices = useSelector((state) => state.fatture.content);
  const dispatch = useDispatch();

  

  useEffect(() => {
    dispatch(getAllInvoicesAction());

    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <Container>
      <table
        style={{ minWidth: "100%", border: "2px solid brown" }}
        class="table"
      >
        <thead>
          <tr>
            <th scope="col">Numero</th>
            <th scope="col">Anno</th>
            <th scope="col">Data</th>
            <th scope="col">Importo</th>
            <th scope="col">Stato</th>
            <th scope="col">Info fattura</th>
          </tr>
        </thead>
        <tbody>
          {invoices &&
            invoices.content.map((invoice) => (
              <>
                <tr>
                  <td>{invoice.numero}</td>
                  <td>{invoice.anno}</td>
                  <td>{invoice.data}</td>
                  <td>{invoice.importo}</td>
                  <td>{invoice.stato}</td>
                  <td>
                  <Link to={`/fatture/${invoice.id}`} style={{ marginTop: "2rem", display: "flex", justifyContent: "center" }}>
        <Button type="button"> Dettagli</Button>
      </Link>
                  </td>
                </tr>
              </>
            ))}
        </tbody>
      </table>
      <Link to="/menu " style={{ margin: "2rem" }}>
        <Button type="button"> Torna indietro</Button>
      </Link>
    </Container>
  );
};

export default InvoicesList;
