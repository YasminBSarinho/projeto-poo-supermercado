package sistema.utilitarios;
import java.io.FileOutputStream;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import sistema.SistemaMercado;

public class Pdf {
    
    public void gerarBalancoMensal(SistemaMercado sistema){
        try {
			Document doc = new Document(PageSize.A4, 72, 72, 72, 72);
			PdfWriter.getInstance(doc, new FileOutputStream("Balanco.pdf"));
            doc.open();

            Font fonte = new Font(FontFamily.HELVETICA, 20, Font.BOLD);
            Paragraph titulo = new Paragraph("Balanço Mensal", fonte); 
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(40);

            //Criando tabelas
            PdfPTable tabelaVendas = criarTabela(5, "Vendas");
            PdfPTable tabelaCompras  = criarTabela(5, "Compras");
            PdfPTable tabelaBalanco = criarTabela(3, "Balanço Mensal");
            String[] tituloProdutos = {"Códgio", "Unidade", "Nome", "Valor Unit.", "Total"};
            String[] titulosBalanco = {"Total Comprado", "Total vendido","Total apurado"};

            float totalComprado = sistema.calcularTotalDeCompras();
            float totalVendido = sistema.calcularTotalDeVendas();
            float totalApurado = sistema.calcularTotalApurado();
            
            // Adicionando titulos e valores das colunas
            addTitulosColunas(tituloProdutos, tabelaVendas);
            addTitulosColunas(tituloProdutos, tabelaCompras);
            addTitulosColunas(titulosBalanco, tabelaBalanco);
            addLinha(sistema.getRegistrosDeVenda(), tabelaVendas);
            addLinha(sistema.getRegistrosDeCompra(), tabelaCompras);

            //tabela dos totais
            tabelaBalanco.addCell(String.valueOf(totalComprado));
            tabelaBalanco.addCell(String.valueOf(totalVendido));
            tabelaBalanco.addCell(String.valueOf(totalApurado));
            
            //Adicionando tabelas ao documento
            doc.add(titulo);
            doc.add(tabelaCompras);
            doc.add(tabelaVendas);
            doc.add(tabelaBalanco);
            doc.close();
            
		} catch (Exception e) {
			e.printStackTrace();
        }
	}

    
    public PdfPTable criarTabela(int colunas, String titulo){            
        PdfPTable tabela = new PdfPTable(colunas);
        Paragraph p = new Paragraph(titulo);
        p.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cabecalho = new PdfPCell(p);
        cabecalho.setColspan(colunas);
        cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabela.addCell(cabecalho);
        tabela.setSpacingAfter(40);
        return tabela;
    }

    public void addTitulosColunas(String[] titulos, PdfPTable tabela) throws Exception{
        if(tabela.getNumberOfColumns() != titulos.length){
            throw new Exception("Há mais titulos do que colunas");
        }
        for(String titulo : titulos){
            tabela.addCell(titulo);
        }
    }
    
    public void addLinha(ArrayList<Registro> registros, PdfPTable tabela){
        for(Registro registro : registros){
            tabela.addCell(registro.getCodigo());
            tabela.addCell(String.valueOf(registro.getUnidades()));
            tabela.addCell(registro.getNome());
            tabela.addCell(String.valueOf(registro.getValor()));
            tabela.addCell(String.valueOf(registro.getUnidades() * registro.getValor()));
        }
    }

}