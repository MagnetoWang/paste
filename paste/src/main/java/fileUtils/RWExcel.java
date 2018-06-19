package fileUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class RWExcel {

    public static void main(String[] args) {
//        writeExcel();
        readExcel();

    }

    /**
     * @author  MagnetoWang
     * д��excel�ļ� ����׺�� xls
     */
    public static void writeExcel(){
        // ����һ��Excel�ļ�
        HSSFWorkbook workbook = new HSSFWorkbook();
        // ����һ��������
        HSSFSheet sheet = workbook.createSheet("ѧ����һ");
        // ��ӱ�ͷ��
        HSSFRow hssfRow = sheet.createRow(0);
        // ���õ�Ԫ���ʽ����
        HSSFCellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);

        // ��ӱ�ͷ����
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("query");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("type");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("name");
        headCell.setCellStyle(cellStyle);
        //��������ģ��
        for (int i = 0; i < 10; i++) {
            hssfRow = sheet.createRow((int) i + 1);


            // ������Ԫ�񣬲�����ֵ
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue("queryRow");
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue("typeRow");
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(2);
            cell.setCellValue("����");
            cell.setCellStyle(cellStyle);
        }
        //�����ļ�����
        try {
            OutputStream outputStream = new FileOutputStream("src/resourse/test.xls");
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("write end");
    }

    /**
     * ע���ļ���ַλ��
     * ��excel �ļ�
     */

    public static void readExcel(){
        List<Student> list = new ArrayList<Student>();
        HSSFWorkbook workbook = null;

        try {
            // ��ȡExcel�ļ�
            InputStream inputStream = new FileInputStream("src/resourse/test.xls");
            workbook = new HSSFWorkbook(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ѭ��������
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // ѭ����
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }

                // ����Ԫ���е����ݴ��뼯��
                Student student = new Student();

                HSSFCell cell = hssfRow.getCell(0);
                if (cell == null) {
                    continue;
                }
                student.setName(cell.getStringCellValue());

                cell = hssfRow.getCell(1);
                if (cell == null) {
                    continue;
                }
                student.setAge((int) cell.getNumericCellValue());

                cell = hssfRow.getCell(2);
                if (cell == null) {
                    continue;
                }
                student.setGrade(cell.getStringCellValue());

                list.add(student);
            }
        }
        //��ӡ��ȡ������
        for(Student e : list){
            System.out.println(e.Age+" "+ e.Grade);
        }
//        return list;

    }
    static class Student{
        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String query;
        private String type;
        private String name;
        private int Age;

        public int getAge() {
            return Age;
        }

        public void setAge(int age) {
            Age = age;
        }

        public String getGrade() {
            return Grade;
        }

        public void setGrade(String grade) {
            Grade = grade;
        }

        private String Grade;
    }
}
