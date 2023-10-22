import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileInputStream
import java.util.logging.Level
import java.util.logging.LogManager

fun matricularAlunos() {
    val arquivoExcel = FileInputStream("c:/dio/desafio-kotlin/cdc.xlsx")
    val workbook = XSSFWorkbook(arquivoExcel)
    val sheet = workbook.getSheetAt(0) // Suponha que os dados estejam na primeira planilha (índice 0)

    var primeiraLinha = true // Variável de controle para verificar a primeira linha

    println("Formação - Ciência da Computação")

    for (row in sheet) {
        if (primeiraLinha) {
            primeiraLinha = false
            continue // Pular a primeira linha (cabeçalhos)
        }

        val cellValue1 = row.getCell(0)?.stringCellValue
        val cellValue2 = row.getCell(1)?.stringCellValue
        val cellValue3 = row.getCell(2)?.stringCellValue

        println("Usuário: $cellValue1, Conteúdo Educacional: $cellValue2, Semestre: $cellValue3")

    }
    arquivoExcel.close()
}

fun main() {
    val rootLogger = LogManager.getLogManager().getLogger("")
    rootLogger.level = Level.WARNING
    matricularAlunos() // Chama a função que faz a matrícula de alunos
}
