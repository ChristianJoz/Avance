
package Print;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementarn;
import Model.Categoria;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {
    private Object Chunck;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try  {
            CategoriaDAOImplementarn cat = new CategoriaDAOImplementarn();
            try{
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                
                documento.open();
                
                Paragraph par1 = new Paragraph();
                Font ftitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLACK);
                par1.add(new Phrase("Lista de Categorias",ftitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);
                
                Paragraph par2 = new Paragraph();
                Font fdesc = new Font(Font.FontFamily.HELVETICA,12,Font.NORMAL,BaseColor.BLACK);
                par2.add(new Phrase("Categorias segun su estado",fdesc));
                par2.setAlignment(Element.ALIGN_JUSTIFIED);
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.add(new Phrase(Chunk.NEWLINE));
                documento.add(par2);
                
                PdfPTable tabla = new PdfPTable(3);
                PdfPCell celda1 = new PdfPCell(new Paragraph("ID",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda2 = new PdfPCell(new Paragraph("NOMBRE",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda3 = new PdfPCell(new Paragraph("STATUS",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLUE)));
                
                tabla.addCell(celda1);
                tabla.addCell(celda2);
                tabla.addCell(celda3);
                
                CategoriaDAO categoria = new CategoriaDAOImplementarn();
       java.util.List<Categoria> listar = categoria.Listar();
        
       
        for ( Categoria categoriaListar : listar) {
            String v1 = String.valueOf(categoriaListar.getId_categoria());
            String v2 = String.valueOf(categoriaListar.getEstado_categoria());
            tabla.addCell(v1);
            tabla.addCell(categoriaListar.getNom_categoria());
            tabla.addCell(v2);
            
        }
                
                 documento.add(tabla);
                documento.close();
                
                
                
            }catch(DocumentException ex){
            ex.getMessage();
            }
           
        } finally{
        out.close();
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
