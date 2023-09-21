import { useEffect } from "react";
import { Container, Button } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { useParams, Link } from "react-router-dom";
import { getInvoiceAction } from "../redux/actions";
import { jsPDF } from "jspdf";

const InvoiceDetail = () => {
const invoice = useSelector((state) => state.fattura.content);
const dispatch = useDispatch();
const params = useParams();

const doc = new jsPDF('p','mm',[297, 210]);

  const invoiceDoc = document.getElementById("invoiceDoc");

  const downloadPdf = async () => {
    
    await doc.html(invoiceDoc).save("test.pdf");
  };

useEffect(() => {
    dispatch(getInvoiceAction(params.id));
}, [])

  return (
    <Container>
      <table 
        class="table"
      >
        <tbody id="invoiceDoc">
          <tr>
            <td>Fattura num: </td>
            <td>{invoice.numero}</td>
          </tr>
          <tr>
            <td>Anno: </td>
            <td>{invoice.anno}</td>
          </tr>
          <tr>
            <td>Data: </td>
            <td>{invoice.data}</td>
          </tr>
          <tr>
            <td>Importo: </td>
            <td>{invoice.importo}</td>
          </tr>
          <tr>
            <td>Stato: </td>
            <td>{invoice.stato}</td>
          </tr>
        </tbody>
      </table>
      <Link to="/fatture " style={{ marginTop: "2rem" }}>
        <Button type="button"> Torna indietro</Button>
      </Link>
      <Button id="save-pdf" onClick={downloadPdf}>
        Save PDF
      </Button>
    </Container>
  );
};

export default InvoiceDetail;
