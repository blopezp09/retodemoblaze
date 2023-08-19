# Documentación técnica de la automatización

## 🌐 Introducción
Demoblaze ha experimentado desafíos tecnológicos y operativos que han afectado su rendimiento y reputación. Por lo tanto se han automatizado algunos escenarios de prueba para validar ciertos flujos a nivel de front, los cuales se han tenido en cuenta para una posterior regresión.

Adicionalmente se ha utilizado el Framework Serenity BDD con el patrón de diseño Screen play y el lenguaje Gherkin el cual se utiliza para escribir los escenarios de prueba en Cucumber.

## 📄 Requisitos

### Requisitos de Sofware
- Google Chrome en su última versión.
- Java en su verdión 17.
- Gradle en su versión 8.1.
- InteliiJ IDEA. 
- Sistema operativo Windows o Linux.

### Requisitos de Hardware
- Al menos un procesador de doble núcleo, aunque un procesador de cuatro núcleos o más es ideal.
- Mínimo de 4GB de RAM.
- Conexión de red.

## 📑 Escenarios de prueba automatizados

### Compras de productos en la página web

```gherkin

# language: es

Característica: Realizar compras de productos en la página web
Como usuario de Demoblaze
Quiero realizar compras de productos desde la página web
Para adquirir los artículos tecnológicos que deseo

    Escenario: Validar que se pueda realizar una compra de productos exitosamente
        Dado que el usuario se encuentra en la página web
        Cuando el usuario selecciona los productos a comprar
        Y registra sus datos de compra exitosamente
        Entonces el sistema retornará el mensaje "Thank you for your purchase!"

    Escenario: Validar que se pueda eliminar algún producto seleccionado
        Dado que el usuario haya seleccionado los productos a comprar
        Cuando el usuario elimina un producto
        Entonces en el resumen de compra se mostrarán los productos seleccionados exceptuando el eliminado

    Escenario: Verificar que el total a pagar corresponda a los precios de los productos seleccionados
        Dado que el usuario haya seleccionado los productos a comprar en la página
        Cuando el usuario navega por la vista del resumen de compra y obtiene el total a pagar
        Entonces el total a pagar corresponderá al total de los precios de los productos seleccionados
```
###  Registro y logueo en la página web

```gherkin

# language: es

Característica: Realizar registro y logueo en la página web
Como usuario de la página web Demoblaze
Quiero registrarme y luego loguearme
Para acceder a las funcionalidades exclusivas para usuarios registrados

    Escenario: Verificar que un usuario se pueda registrar en la página exitosamente
        Dado que el usuario haya ingresado a la página
        Cuando el usuario se registra en la página exitosamente
        Entonces la página mostrará una alerta "Sign up successful."

    Escenario: Verificar que un usuario se pueda loguear y su usuario se pueda visualizar
        Dado que el usuario se haya registrado en la página web
        Cuando el usuario suministra los datos para loguearse y valida
        Entonces se mostrará su usuario "Welcome " seguido de su usuario
```
## 📂 Estructura del Proyecto

- **Escenarios de prueba**: src/test/resources/features
- **Configuración del chromedriver**: src/test/java/co/com/sofka/setup/DriverConfiguration.java
- **Steps definitions**: src/test/java/co/com/sofka/stepdefinitions
- **Runner**: src/test/java/co/com/sofka/runners
- **Actions**: src/main/java/co/com/sofka/actions/commonactions
- **Models**: src/main/java/co/com/sofka/models
- **Questions**: src/main/java/co/com/sofka/questions
- **Tasks**: src/main/java/co/com/sofka/tasks
- **Utils**: src/main/java/co/com/sofka/utils

## ✅ ¿Cómo ejecutar el código?

- La automatización se puede ejecutar desde el propio InteliiJ IDEA, con solo darle a ejecutar el Runner.
- Si se requiere ejecutar desde la consola, solo es ir al Root del proyecto y ejecutar el siguiente comando: gradlew test --tests=co.com.sofka.runners.retoDemoBlazeRunner --info 

## 🔂 ChromeDriver 

Actualmente el ChromeDriver se obtiene de manera automática, descargando y utilizando la última versión dependiendo de cuál sistema operativo se está utlizando.

```Bash
        switch (os) {
            case "linux" -> WebDriverManager.chromedriver().linux().setup();
            case "windows" -> WebDriverManager.chromedriver().win().setup();
            default -> throw new RuntimeException("Sistema operativo no soportado para ejecutar la automatización");
        }
```

Si se requiere utilizar una versión específica solo es cuestión de agregar lo siguiente.

```Bash
        switch (os) {
            case "linux" -> WebDriverManager.chromedriver().version("VerionAUtilizar").linux().setup();
            case "windows" -> WebDriverManager.chromedriver().version("VerionAUtilizar").win().setup();
            default -> throw new RuntimeException("Sistema operativo no soportado para ejecutar la automatización");
        }
```

## 📋 Datos de entrada

Para obtener datos de entrada para los formularios de manera aleatoria, se utiliza la librería

```Bash
    'net.andreinc:mockneat:0.4.8'
```

Por ejemplo si se requiere un nombre aleatorio, se realiza lo siguiente 
```Bash
    private final MockNeat mock = MockNeat.threadLocal();
    registroLogueoUsuarioModel.setUsuario(mock.users().val());
```

## ➡️ Selcción de productos aleatorios

Para esta implementación se obtienen los css selectors de manera general y luego con un método de generación de números aleatorios, se lo asignamos al selector. 

```Bash
    public static final Target PRODUCTO = Target.the("Product").locatedBy("#tbodyid > div:nth-child({0}) > div > div > h4 > a");
    Click.on(PRODUCTO.of(String.valueOf(productosRestantes)).resolveFor(actor));

```
