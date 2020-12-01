import logicRAD.isOperator
import java.util.*
import kotlin.math.pow


fun String.toSufijo(): String {
    val colaDeSalida = mutableListOf<String>()
    val stackDeOperadores = mutableListOf<String>()
    val tokens = this.toTokens()

    while (tokens.isNotEmpty()) {
        val token = tokens.first()

        if (token[0].isLetterOrDigit()) {
            colaDeSalida.add(token)
        } else if (token[0].isOperator()) {
            if (stackDeOperadores.isEmpty())
                stackDeOperadores.add(token)
            else {
                while (stackDeOperadores.size>0 && stackDeOperadores.last()[0].isOperator()) {
                    if (stackDeOperadores.last()[0].precedes(token[0])){
                        colaDeSalida.add(stackDeOperadores.last())
                        stackDeOperadores.removeLast()
                    }else {
                        break
                    }
                }
                if (token[0] != ')')
                    stackDeOperadores.add(token)
            }
        } else if (token[0] == '(') {
            stackDeOperadores.add(token)
        } else if (token[0] == ')') {
            while (stackDeOperadores.last()[0] != '(') {
                colaDeSalida.add(stackDeOperadores.last())
                stackDeOperadores.removeLast()
            }
            stackDeOperadores.removeLast()
        }

        tokens.removeFirst()
    }

    while (stackDeOperadores.isNotEmpty()) {
        colaDeSalida.add(stackDeOperadores.last())
        stackDeOperadores.removeLast()
    }

    return colaDeSalida.toShortString()
}

//algoritmo RPN
fun String.calculate(): String {
    val st = StringTokenizer(this)
    val pila = mutableListOf<String>()

    while (st.hasMoreTokens()) {
        val token = st.nextToken()
        try {
            when {
                token[0].isDigit() -> {
                    pila.add(token)
                }
                token[0].isLetter() -> {
                    return ""
                }
                token[0].isOperator() -> {
                    pila[pila.lastIndex - 1] = when (token) {
                        "+" -> (pila[pila.lastIndex - 1].toDouble() + pila[pila.lastIndex].toDouble()).toString()
                        "-" -> (pila[pila.lastIndex - 1].toDouble() - pila[pila.lastIndex].toDouble()).toString()
                        "*" -> (pila[pila.lastIndex - 1].toDouble() * pila[pila.lastIndex].toDouble()).toString()
                        "/" -> (pila[pila.lastIndex - 1].toDouble() / pila[pila.lastIndex].toDouble()).toString()
                        "^" -> (pila[pila.lastIndex - 1].toDouble().pow(pila[pila.lastIndex].toDouble())).toString()
                        else -> "error"
                    }
                    pila.removeLast()
                }
            }
        } catch (e: Exception) {
            return ""
        }

    }
    return pila[0]
}

private fun MutableList<String>.toShortString(): String {
    var resultado = ""
    for (i in this) {
        resultado += "$i "
    }
    return resultado
}

private fun String.toTokens(): MutableList<String> {
    var str = this
    val tokens = mutableListOf<String>()
    var token = ""

    while (str.isNotEmpty()) {
        if(str[0].isOperator() || str[0] == '(' || str[0] == ')') {
            if(token.isEmpty()) {
                tokens.add(str[0].toString())
                str = str.substring(1, str.length)
            } else {
                tokens.add(token)
                token = ""
            }
        }else if(str[0].isLetterOrDigit()) {
            token += str[0]
            str = str.substring(1, str.length)
            if(str.isEmpty())
                tokens.add(token)
        }
    }

    return tokens
}

private fun Char.precedes(c: Char): Boolean {
    return if (c == '(' || this == 'C')
        false
    else if (c == ')' || c == '+' || c == '-')
        true
    else if (this == '^')
        true
    else if (c == '^')
        false
    else this == '*' || this == '/'

}
