package utils.markdown;

import com.qkyrie.markdown2pdf.Markdown2PdfConverter;
import com.qkyrie.markdown2pdf.internal.writing.SimpleFileMarkdown2PdfWriter;

import java.io.File;

public class ToPdf {
    public static void main(String[] args) {
        Markdown2PdfConverter markdown2PdfConverter =
                Markdown2PdfConverter.newConverter();
        Markdown2PdfConverter
                .newConverter()
                .writeTo(new SimpleFileMarkdown2PdfWriter(new File("install.md")));

    }
}
