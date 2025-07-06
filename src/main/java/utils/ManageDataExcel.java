package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import exceptions.CaseFailedException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ManageDataExcel {
    private static String rutaArchivoExcel = "";


    // Método para guardar el valor en una celda enviando el nombre de la hoja, número de columna y número de fila
    public static void escribirValorCelda(String nombreHoja, int numeroFila, int numeroColumna, String nuevoValor) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(rutaArchivoExcel);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            // Obtener la hoja por su nombre
            Sheet sheet = workbook.getSheet(nombreHoja);
            if (sheet == null) {
                throw new CaseFailedException("No se encontró la hoja " + nombreHoja);
            }

            // Obtener la fila, si no existe crearla
            Row fila = sheet.getRow(numeroFila);
            if (fila == null) {
                fila = sheet.createRow(numeroFila);
            }

            // Obtener la celda, si no existe crearla
            Cell celda = fila.getCell(numeroColumna);
            if (celda == null) {
                celda = fila.createCell(numeroColumna);
            }

            // Escribir el nuevo valor en la celda
            celda.setCellValue(nuevoValor);

            // Guardar los cambios en el archivo
            try (FileOutputStream outputStream = new FileOutputStream(rutaArchivoExcel)) {
                workbook.write(outputStream);
            }
        }
    }

    //=============== Obtener los usuarios de forma dinámica sin importar el número de usuarios ============================

    // Método para instanciar un usuario enviando el nombre del usuario
    public static Users getUsuarioPorNombre(String nombreUsuario) throws Exception {
        // Abrir el archivo Excel
        FileInputStream file = new FileInputStream(rutaArchivoExcel);
        Workbook workbook = new XSSFWorkbook(file);

        // Leer la hoja de Usuarios
        Sheet userSheet = workbook.getSheet("Usuarios");
        for (Row row : userSheet) {
            if (row.getRowNum() == 0) continue; // Saltar la cabecera
            String excelUsuario = getStringCellValue(row.getCell(0));

            // Buscar el usuario por nombre
            if (excelUsuario.equalsIgnoreCase(nombreUsuario)) {
                String nombre = getStringCellValue(row.getCell(1));
                String identificacion = getStringCellValue(row.getCell(2));
                String contrasena = getStringCellValue(row.getCell(3));
                String token = getStringCellValue(row.getCell(4));
                int fila = row.getRowNum();

                // Instanciamos y devolvemos el usuario deseado
                return new Users(nombre, identificacion, contrasena, token, fila);
            }
        }

        workbook.close();
        return null; // No se encontró el usuario
    }

    // Método auxiliar para obtener el valor de la celda como String
    private static String getStringCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                // Si el valor numérico es un entero, conviértelo a Long y luego a String
                if (DateUtil.isCellDateFormatted(cell)) {
                    // Manejo especial para fechas
                    return cell.getDateCellValue().toString();
                } else {
                    // Redondear a un entero antes de convertir a String
                    return String.valueOf((long) cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
