
/**
 * Clase que representa un objeto Coche con propiedades como color, marca, modelo, número de caballos,
 * número de puertas y matrícula.
 *
 * @param color El color del coche.
 * @param marca La marca del coche.
 * @param modelo El modelo del coche.
 * @param numcaballos El número de caballos del coche.
 * @param numpuertas El número de puertas del coche.
 * @param matricula La matrícula del coche.
 *
 * @throws IllegalArgumentException Si algún parámetro no cumple con las restricciones especificadas.
 */
class Coche(color:String,
            marca:String,
            modelo:String,
            private val numcaballos:Int,
            private val numpuertas:Int,
            private val matricula:String
){

    /**
     * El color del coche.
     * No puede ser un campo vacío.
     */
    private var color:String = color
        set(value) {
            require(value.isNotEmpty()) {"Color no debe ser un campo vacio"}
            field = value
        }

    /**
     * La marca del coche (en mayúsculas).
     */
    private var marca: String = marca
        get() = field.uppercase()

    /**
     * El modelo del coche (en mayúsculas).
     */
    private var modelo:String = modelo
        get() = field.uppercase()

    /**
     * Inicializador que verifica las restricciones especificadas para los parámetros.
     *
     * @throws IllegalArgumentException Si alguna restricción no se cumple.
     */
    init {
        require(marca.trim().isNotBlank()) {"Marca no puede ser blanco ni nulo."}
        require(modelo.trim().isNotEmpty()) {"Modelo no puede ser blanco ni nulo."}
        require(numcaballos in 70..700) {"Los caballos tienen que oscilar entre 70 y 700"}
        require(numpuertas in 3..5) {"Las puertas tienen que oscilar entre 3 y 5"}
        require(matricula.trim().isNotBlank()) {"Matricula no puede ser nula."}
        require(matricula.length <= 7) {"Matricula no puede tener mas de 7 caracteres"}
        require(color.isNotBlank()) {"El color no puede estar vacio"}
    }

    /**
     * Representación en cadena del objeto [Coche].
     *
     * @return Una cadena que representa las propiedades del coche.
     */
    override fun toString(): String {
        return "Coche: \n color: $color \n marca: $marca \n modelo: $modelo \n caballos: $numcaballos \n Puertas: $numpuertas \n matricula: $matricula "
    }
}


    /**
     * Función principal que crea un objeto [Coche] y lo imprime.
     */
fun main() {
    try {
        val coche1 = Coche("azul", "Volkswagen", "ar 205", 130, 5, "2575jkk")
        println(coche1.toString())
    }catch (e:IllegalArgumentException){
        println(e.message)
    }catch (e:Exception){
        println("Error inesperado")
    }
}