import swingRAD.sComponents.SMenuBar
import swingRAD.setMainBar
import swingRAD.setProperties
import javax.swing.*

class Window: JFrame() {

    init{
        createMenuBar()
        createGUI()
        createFrame()
    }

    private fun createGUI() {
        val lInput = JLabel()
        lInput
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

}