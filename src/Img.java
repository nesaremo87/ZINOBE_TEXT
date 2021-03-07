

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Img {
    static int img=0;
    static Document documento;
	public static String ruta;

	public static Document PDF(String nombre1) throws IOException, DocumentException {
		// METODO QUE CREA UN PDF PARA PRESENTAR LOS RESULTADOS DE LOS SCRIPT
		String nombre = "evidencias";
		// SE CREA UN DOCUMENTO CON TAMAÑO CARTA Y SE ESCOJE LA RUTA Y NOMBRE
		documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
		String archivo = "D:/img" + nombre1 + ".pdf" ;
		
		PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(archivo, true));

		documento.addTitle("Registro Pruebas de Regresión Transacción - " + nombre);
		documento.addAuthor("caso");
		documento.open();

		// SE CREA UN PARAGRAFO QUE LLEVA EL ENCABEZADO DEL DOCUMENTO TITULO
		Paragraph titulo = new Paragraph();
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		titulo.setFont(FontFactory.getFont("Sans", 15, Font.BOLD));
		titulo.add("REGISTRO PRUEBAS DE REGRESION CEC - " + nombre + "\n\n");

		// SE AGREGA EL PARAGRAFO AL DOCUMENTO
		documento.add(titulo);

		return documento;
	}
	
	public static void getCapturaImagen(String respuesta) {
		try {
	
			String ruta = "D:/img/" + respuesta + ".png";
			System.out.println("antes de obtener la pantalla");
			File scrFile = ((TakesScreenshot) Configuracion.getDriver()).getScreenshotAs(OutputType.FILE);
			System.out.println("captura pantalla");
			FileUtils.copyFile(scrFile, new File(ruta));
			setImagenPDF(ruta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setImagenPDF(String ruta) {
		Image imagen;
		try {
			imagen = Image.getInstance(ruta);
			imagen.setAlignment(Image.ALIGN_CENTER);
			imagen.setUseVariableBorders(true);
			imagen.scalePercent(40);
			getDocumento().add(imagen);
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}


	
	/* Método para cerrar PDF */
	public void closePDF() {
		documento.close();
	}

	public static Document getDocumento() {
		return documento;
	}

	

}
