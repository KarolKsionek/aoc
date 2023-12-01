import java.io.File

object FileHelper {

    fun getFile(name: String): File {
        return File(object {}.javaClass.getResource("/$name")!!.toURI().path)
    }
}