import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { getAllInvoicesAction } from "../redux/actions";
import { Button, Container } from "react-bootstrap";
import { Link } from "react-router-dom";
import { jsPDF } from "jspdf";

const InvoicesList = () => {
  const invoices = useSelector((state) => state.fatture.content);
  const dispatch = useDispatch();

  const doc = new jsPDF('p', 'mm', [297, 210]);
  
  
  const invoice = document.getElementById("invoice");

  const downloadPdf = async () => {
    doc.setFontSize(1);
    await doc.html(invoice).save("test.pdf");
  };

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
            <th scope="col">Download</th>
          </tr>
        </thead>
        <tbody>
          {invoices &&
            invoices.content.map((invoice) => (
              <>
                <tr id="invoice" >
                  <td>{invoice.numero}</td>
                  <td>{invoice.anno}</td>
                  <td>{invoice.data}</td>
                  <td>{invoice.importo}</td>
                  <td>{invoice.stato}</td>
                  <td>
                    <Button id="save-pdf" onClick={downloadPdf}>
                      Save PDF
                    </Button>
                  </td>
                </tr>
              </>
            ))}
        </tbody>
      </table>
      <Link to="/menu " style={{ marginTop: "2rem" }}>
        <Button type="button"> Torna indietro</Button>
      </Link>
    </Container>
  );
};

export default InvoicesList;
