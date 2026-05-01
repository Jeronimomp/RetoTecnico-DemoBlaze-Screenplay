
# AUTOMATIZACIÓN DE PRUEBAS - COMPRA EN LÍNEA EN DEMOBLAZE


Proyecto:     Demoblaze Automation
Sitio bajo prueba: https://www.demoblaze.com/
Framework:    Serenity BDD + Cucumber + JUnit
Patrón:       Screenplay
Lenguaje:     Java 17
Build Tool:   Gradle (Kotlin DSL)

================================
1. DESCRIPCIÓN DEL PROYECTO
   ==============================

Este proyecto automatiza el flujo principal de compra de un producto en el sitio
web Demoblaze, validando los siguientes pasos:

1. Ingresar a la página principal del sitio.
2. Seleccionar un producto del catálogo.
3. Agregar el producto al carrito de compras.
4. Visualizar el producto en el carrito.
5. Realizar el pedido completando los datos del cliente.
6. Verificar el mensaje de confirmación de compra exitosa.

================================
2. REQUISITOS PREVIOS
   =========================

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- Java JDK 17 o superior
  Verificar con:  java -version

- Gradle 8.x (opcional, el proyecto incluye gradlew)
  Verificar con:  gradle -v

- Google Chrome (última versión estable)
  Serenity descarga automáticamente el ChromeDriver compatible.

- Git (para clonar el repositorio)
  Verificar con:  git --version

- IDE recomendado: IntelliJ IDEA (Community o Ultimate)
  Con los plugins:
  * Cucumber for Java
  * Gherkin
  * Lombok

================================
3. ESTRUCTURA DEL PROYECTO
   =============================

Demoblaze/
│
├── build.gradle.kts                  -> Configuración de dependencias Gradle
├── serenity.properties               -> Configuración de Serenity BDD
├── settings.gradle.kts
│
├── src/main/java/com/demoblaze/
│   ├── interactions/                 -> Interacciones reutilizables (AceptarAlerta)
│   ├── models/                       -> Modelos de datos (DatosClienteModel)
│   ├── questions/                    -> Preguntas/validaciones (ValidaCompraExitosa)
│   ├── tasks/                        -> Tareas del actor (Screenplay)
│   │   ├── AbrirPagina.java
│   │   ├── SeleccionaProducto.java
│   │   ├── AgregaProducto.java
│   │   ├── VisualizaCarrito.java
│   │   └── RealizaPedido.java
│   ├── ui/                           -> Targets / Page Objects
│   │   ├── HomePage.java
│   │   └── CartPage.java
│   └── utilidades/
│       └── Constantes.java
│
├── src/test/java/com/demoblaze/
│   ├── hooks/
│   │   ├── Principal.java            -> Setup del escenario (OnStage)
│   │   └── DataTableDefinitions.java -> Mapeo de DataTables a modelos
│   ├── runners/
│   │   └── RunnerRealizarCompra.java -> Runner principal de Cucumber
│   └── stepdefinitions/
│       └── StepRealizarCompra.java   -> Pegamento entre features y tasks
│
└── src/test/resources/
└── feature/
└── ComprarProducto.feature   -> Escenarios en Gherkin

============================
4. CLONAR EL PROYECTO
   ==========================

git clone <URL-del-repositorio>
cd Demoblaze

=======================================
5. INSTALACIÓN DE DEPENDENCIAS
   ====================================

Las dependencias se descargan automáticamente con Gradle al ejecutar cualquier
tarea. También puedes forzar la descarga con:

En Windows:
.\gradlew build -x test

En Linux/Mac:
./gradlew build -x test

==================================
6. EJECUCIÓN DE LAS PRUEBAS
   ===============================

--- Opción A: Ejecución completa desde la terminal ---

En Windows (PowerShell o CMD):
.\gradlew clean test

En Linux/Mac:
./gradlew clean test

--- Opción B: Ejecución desde IntelliJ IDEA ---

1. Abrir el proyecto en IntelliJ.
2. Esperar a que Gradle termine de sincronizar las dependencias.
3. Navegar a:
   src/test/java/com/demoblaze/runners/RunnerRealizarCompra.java
4. Click derecho sobre la clase y seleccionar:
   "Run 'RunnerRealizarCompra'"

--- Opción C: Ejecutar directamente el archivo .feature ---

1. Abrir:  src/test/resources/feature/ComprarProducto.feature
2. Click derecho sobre el escenario.
3. Seleccionar "Run Scenario".

==================================
7. GENERACIÓN DE REPORTES
   ================================

Serenity genera un reporte HTML detallado al finalizar las pruebas.

Para generarlo manualmente:

       En Windows:    .\gradlew aggregate
       En Linux/Mac:  ./gradlew aggregate

Ubicación del reporte:
target/site/serenity/index.html

Abrir el archivo "index.html" en el navegador para visualizar:
- Resultados de cada escenario
- Capturas de pantalla por cada paso
- Tiempos de ejecución
- Trazabilidad de requisitos

====================================
8. CONFIGURACIÓN PERSONALIZABLE
   ==================================

Archivo: serenity.properties

Propiedades más importantes:

       webdriver.driver=chrome              -> Browser a utilizar
       webdriver.autodownload=true          -> Descarga automática del driver
       webdriver.base.url=https://www.demoblaze.com/index.html
       serenity.take.screenshots=AFTER_EACH_STEP
       webdriver.wait.for.timeout=10000     -> Timeout en milisegundos

==================================
9. ESCENARIO AUTOMATIZADO
   ================================

Feature: Comprar producto en demoblaze

    Scenario: Comprar un producto exitosamente
      Given El usuario está en la página de inicio de demoblaze
      When El usuario selecciona el producto
      And El usuario agrega el producto al carrito
      And El usuario va al carrito y visualiza el producto agregado
      And El usuario realiza el pedido y llena formulario de compra con
          los siguientes datos:
        | nombre | pais | ciudad   | tarjeta             | mes | anio |
        | Juan   | USA  | New York | 1234 5678 9012 3456 | 12  | 2025 |
      Then Debería ver un mensaje de confirmación de compra exitosa

=======================================
10. SOLUCIÓN DE PROBLEMAS COMUNES
    ====================================

* Error: "Cannot access net.serenitybdd.core.pages.ResolvableElement"
  -> Recargar el proyecto Gradle desde IntelliJ (botón de "Sync").

* Error: ChromeDriver incompatible con la versión de Chrome
  -> Verificar que webdriver.autodownload=true en serenity.properties
  y borrar la caché de drivers en: ~/.cache/selenium/

* No se generan los reportes Serenity
  -> Ejecutar manualmente:  .\gradlew aggregate

* El navegador no abre / se cierra inmediatamente
  -> Verificar la versión de Chrome instalada y reiniciar el equipo.

* Errores de compilación con Lombok
  -> Habilitar "Annotation Processing" en IntelliJ:
  File > Settings > Build > Compiler > Annotation Processors
  Marcar "Enable annotation processing".

=======================================
11. DEPENDENCIAS PRINCIPALES
    ====================================

- net.serenity-bdd:serenity-core:4.1.20
- net.serenity-bdd:serenity-screenplay:4.1.20
- net.serenity-bdd:serenity-screenplay-webdriver:4.1.20
- net.serenity-bdd:serenity-cucumber:4.1.20
- io.cucumber:cucumber-java:7.15.0
- org.junit.jupiter:junit-jupiter:5.10.0
- io.github.bonigarcia:webdrivermanager:5.7.0
- org.assertj:assertj-core:3.25.1
- org.projectlombok:lombok:1.18.30

====================================
12. AUTOR
    ================================

Autor:        Angel Marzola
Empresa:      Sofka Technologies
Tipo:         Prueba Técnica - Automatización Web
Fecha:        2026

=============================
FIN DEL DOCUMENTO
==============================
