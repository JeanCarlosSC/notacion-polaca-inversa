import swingRAD.fontTitle
import swingRAD.sComponents.SLabel
import swingRAD.sComponents.SMenuBar
import swingRAD.setMainBar
import swingRAD.setProperties
import javax.swing.*

class Window: JFrame() {

    val jtInput = JTextField()
    val lAnswer = SLabel()

    init{
        createMenuBar()
        createGUI()
        createFrame()
    }

    private fun createGUI() {
        val lInput = SLabel(600, 100, 100, 32, "Input", fontTitle)
        add(lInput)

        jtInput.setProperties(485, 140, 300, 40, hAlignment = JTextField.CENTER)
        jtInput.addActionListener { calculate() }
        add(jtInput)

        val lOutput = SLabel(590, 210, 100, 32, "Output", fontTitle)
        add(lOutput)

        add(lAnswer)

        val pInfo = JPanel()
        pInfo.setProperties(200, 400, 900, 290)
        add(pInfo)

        val taInfo = JTextArea()
        taInfo.setProperties(20, 20, 860, 250, false, background = null, border = null,  text = "Algoritmo:" +
                "\n\n    El algoritmo shunting yard es un método para analizar (parsing) las ecuaciones matemáticas especificadas en la notación de infijo." +
                " Puede ser utilizado para producir la salida en la notación polaca inversa (RPN) o como árbol de sintaxis abstracta (AST). El algoritmo" +
                " fue inventado por Edsger Dijkstra y nombró como algoritmo \"shunting yard\" (patio de clasificación) porque su operación se asemeja al" +
                " de un patio de clasificación del ferrocarril." +
                "\n\n    Como la evaluación del RPN, el algoritmo shunting yard está basado en el stack. Las expresiones de infijo son la forma de matemáticas a" +
                " la que la mayoría de la gente está acostumbrada, por ejemplo 3+4 ó 3+4*(2-1). Para la conversión hay dos variables de texto (strings)," +
                " la entrada y la salida. Hay también un stack que guarda los operadores que todavía no se han añadido a la cola de salida. Para hacer la" +
                " conversión, el programa lee cada símbolo en orden y hace algo basado en ese símbolo.")
        pInfo.add(taInfo)
    }

    private fun createMenuBar() {
        val menuBar = SMenuBar()
        add(menuBar)

        val help = JMenu("Help")
        menuBar.add(help)

        val about = JMenuItem("About")
        about.addActionListener {
            JOptionPane.showMessageDialog(null, "" +
                    "This software has been developed by Jean Carlos Santoya." +
                    "\nReferences:" +
                    "\n - https://es.wikipedia.org/wiki/Notaci%C3%B3n_polaca_inversa" +
                    "\n - https://es.wikipedia.org/wiki/Algoritmo_shunting_yard")
        }
        help.add(about)
    }

    private fun createFrame() {
        setMainBar("Algoritmo shunting yard")
        setProperties()
    }

    private fun calculate() {
        
    }

}