# README #

Para generar el .jar final necesitaremos situarnos en el directorio padre del proyecto y ejecutar: "mvn clean package". Esto genera el jar en la ruta /target previa comprobación de los test.

# ACCIONES REALIZADAS #
- Se ha creado la clase DriverFactory para crear la instancia del navegador
- Se ha refaztorizado la clase BrowserManagerEnum, concretamente el método getDriver(), de forma que se utiliza la clase  DriverFactory para instaciar los navegadores
- En la clase BrowserManagerEnumTest se ha mockeado la clase DriverFactory para no instanciar el navegador, sino una clase genérica.

Al crear un nivel de indirección (es decir, usar una referencia a otra clase), ya se pueden usar spies o mockear esa instancia en los tests usando Mockito. Con eso, se consigue testear el código escrito pero sin necesidad de testear (ejecutar) el código de creación de los Drivers que no necesitan ser testeados ya que provienen de librerías de terceros que ya habrán sido testeadas en esos proyectos